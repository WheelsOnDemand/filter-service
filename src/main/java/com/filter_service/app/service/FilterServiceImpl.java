package com.filter_service.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.filter_service.app.config.ModelMapperService;
import com.filter_service.app.dto.response.GetAllFiltersResponse;
import com.filter_service.app.dto.response.GetFilterResponse;
import com.filter_service.app.kafka.events.BrandUpdatedEvent;
import com.filter_service.app.kafka.events.CarCreatedEvent;
import com.filter_service.app.kafka.events.CarDeletedEvent;
import com.filter_service.app.kafka.events.CarUpdatedEvent;
import com.filter_service.app.kafka.events.ModelUpdatedEvent;
import com.filter_service.app.model.Filter;
import com.filter_service.app.repository.FilterRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {
	
		private  FilterRepository filterRepository;
	    private  ModelMapperService modelMapperService;
		
		@Override
		public List<GetAllFiltersResponse> getAll() {
	        List<Filter> filters = filterRepository.findAll();

	        List<GetAllFiltersResponse> responses = filters.stream().map(filter -> this.modelMapperService.forRequest().map(filter, GetAllFiltersResponse.class))        		
	       				.collect(Collectors.toList());
			return responses;
		}

		@Override
		public List<GetAllFiltersResponse> getByBrandName(String brandName) {
			 List<Filter> filters = this.filterRepository.findAll();
			 List<GetAllFiltersResponse> responses = filters.stream().map(filter -> this.modelMapperService.forRequest().map(filter, GetAllFiltersResponse.class))
					 .collect(Collectors.toList());
					 
					 
				return responses;
		}

		@Override
		public List<GetAllFiltersResponse> getByModelName(String modelName) {
			List<Filter> filters = filterRepository.findByModelName(modelName);
			List<GetAllFiltersResponse> responses=filters.stream().map(filter-> this.modelMapperService.forRequest().map(filter, GetAllFiltersResponse.class))	
					.collect(Collectors.toList());
					return responses;
		}

		@Override
		public GetFilterResponse getByPlate(String plate) {
			Filter filter= filterRepository.findByPlate(plate);
			GetFilterResponse getFiltersResponse = this.modelMapperService.forResponse().map(filter, GetFilterResponse.class);
			return getFiltersResponse;
			
		}
		


		@Override
		public void addCar(CarCreatedEvent carCreatedEvent) {
			Filter filter = this.modelMapperService.forRequest().map(carCreatedEvent, Filter.class);
			this.filterRepository.save(filter);
		}

		@Override
		public List<GetAllFiltersResponse> getByDailyPrice(double min, double max) {
			List<Filter> filters = this.filterRepository.findAll();
			List<GetAllFiltersResponse> responses = new ArrayList<GetAllFiltersResponse>();
			for (Filter filter : filters) {
				if(filter.getDailyPrice()<max && filter.getDailyPrice()>min) {
					GetAllFiltersResponse response = this.modelMapperService.forResponse().map(filter, GetAllFiltersResponse.class);
					responses.add(response);
			
				}
				
			}
			return responses;
		}

		@Override
		public List<GetAllFiltersResponse> getByModelYear(int modelYear) {
			 List<Filter> filters = filterRepository.findByModelYear(modelYear);
		        List<GetAllFiltersResponse> response = filters.stream().map(filter-> this.modelMapperService.forRequest().map(filter, GetAllFiltersResponse.class))	
						.collect(Collectors.toList());
		        		//.map(filter-> modelMapperService.forResponse()
		        		//.map(filter, GetAllFiltersResponse.class));
		        		
		    	return response;	
		
				
			}
		
		



		@Override
		public void updateCar(CarUpdatedEvent carUpdatedEvent) {
			Filter filter = this.modelMapperService.forRequest().map(carUpdatedEvent, Filter.class);
			this.filterRepository.save(filter);
		}
			
		

		@Override
		public void updateBrand(BrandUpdatedEvent brandUpdatedEvent) {
			List<Filter> filters = this.filterRepository.findByBrandName(brandUpdatedEvent.getBrandName());
			for (Filter filter : filters) {
				filter.setBrandName(brandUpdatedEvent.getBrandName());
				filter.setBrandId(brandUpdatedEvent.getBrandId());
				this.filterRepository.save(filter);
			}
		}

		@Override
		public void updateModel(ModelUpdatedEvent modelUpdatedEvent) {
			List<Filter> filters = this.filterRepository.findByModelName(modelUpdatedEvent.getModelName());
			for (Filter filter : filters) {
				filter.setBrandName(modelUpdatedEvent.getBrandName());
				filter.setBrandId(modelUpdatedEvent.getBrandId());
				filter.setModelName(modelUpdatedEvent.getModelName());
				filter.setModelId(modelUpdatedEvent.getModelId());
				this.filterRepository.save(filter);
			}
		}

		@Override
		public void deleteCar(CarDeletedEvent carDeletedEvent) {
			Filter filter = this.filterRepository.findByCarId(carDeletedEvent.getCarId());
			this.filterRepository.delete(filter);

			
		}
		
		

	}