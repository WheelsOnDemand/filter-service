package com.filter_service.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filter_service.app.dto.response.GetAllFiltersResponse;
import com.filter_service.app.dto.response.GetFilterResponse;
import com.filter_service.app.service.FilterService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/filters")
@AllArgsConstructor
public class FilterController {
	private final FilterService filterService;

    @GetMapping
    public List<GetAllFiltersResponse> getAll() {
        return filterService.getAll();
    }

    @GetMapping("/brand")
    public List<GetAllFiltersResponse> getByBrandName(@RequestParam String brandName) {
        return filterService.getByBrandName(brandName);
    }

    @GetMapping("/model")
    public List<GetAllFiltersResponse> getByModelName(@RequestParam String modelName) {
        return filterService.getByModelName(modelName);
    }
    @GetMapping("/plate")
    public GetFilterResponse getByPlate(@RequestParam String plate) {
        return filterService.getByPlate(plate);
    }
    @GetMapping("/year")
    public List<GetAllFiltersResponse> getByModelYear(@RequestParam int modelYear) {
        return filterService.getByModelYear(modelYear);
    }

    
}