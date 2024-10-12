package com.filter_service.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filter-inventory", schema = "filterdb")
public class Filter {
	@Id
	private String id;
	
	@Column(name = "car_id")
	private String carId;
	
	@Column(name = "brand_id")
	private String brandId;

	@Column(name = "brand_name")
	private String brandName;

	@Column(name = "model_id")
	private String modelId;

	@Column(name = "model_name")
	private String modelName;

	@Column(name = "daily_price")
	private double dailyPrice;

	@Column(name = "model_year")
	private int modelYear;

	@Column(name = "plate")
	private String plate;

	@Column(name = "state")
	private int state;

}
