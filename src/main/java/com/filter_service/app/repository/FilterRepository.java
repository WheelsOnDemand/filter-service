package com.filter_service.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filter_service.app.model.Filter;

public interface FilterRepository extends JpaRepository<Filter, String> {
	
	Filter findByCarId(String carId);
	Filter findByPlate(String plate);
	List<Filter> findByBrandName(String brandName);
	List<Filter> findByModelName(String modelName);
	List<Filter> findByBrandId(String brandId);
	List<Filter> findByModelId(String modelId);
	List<Filter> findByDailyPrice(double dailyPrice);
	List<Filter> findByModelYear(int modelYear);


}