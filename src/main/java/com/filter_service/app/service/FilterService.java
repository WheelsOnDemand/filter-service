package com.filter_service.app.service;

import java.util.List;

import com.filter_service.app.dto.response.GetAllFiltersResponse;
import com.filter_service.app.dto.response.GetFilterResponse;
import com.filter_service.app.kafka.events.BrandUpdatedEvent;
import com.filter_service.app.kafka.events.CarCreatedEvent;
import com.filter_service.app.kafka.events.CarDeletedEvent;
import com.filter_service.app.kafka.events.CarUpdatedEvent;
import com.filter_service.app.kafka.events.ModelUpdatedEvent;

public interface FilterService {
	 List<GetAllFiltersResponse> getAll();
	    List<GetAllFiltersResponse> getByBrandName(String brandName);
	    List<GetAllFiltersResponse> getByModelName(String modelName);
	    GetFilterResponse getByPlate(String plate);
	    List<GetAllFiltersResponse> getByDailyPrice(double min,double max);
	    List<GetAllFiltersResponse> getByModelYear(int modelYear);
	    
	    void addCar(CarCreatedEvent carCreatedEvent);
		void deleteCar(CarDeletedEvent carDeletedEvent);
		void updateCar(CarUpdatedEvent carUpdatedEvent);
		
		void updateBrand(BrandUpdatedEvent brandUpdatedEvent);
		void updateModel(ModelUpdatedEvent modelUpdatedEvent);
	}