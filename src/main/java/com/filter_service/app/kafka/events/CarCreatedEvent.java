package com.filter_service.app.kafka.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarCreatedEvent {
	private String message;
	private String carId;
	private String brandId;
	private String brandName;
	private String modelId;
	private String modelName;
	
}