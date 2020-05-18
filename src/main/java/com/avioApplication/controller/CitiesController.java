package com.avioApplication.controller;

import com.avioApplication.entity.AirportData;
import com.avioApplication.entity.CitiesEntity;
import com.avioApplication.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CitiesController {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private CitiesService citiesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CitiesEntity saveCity(
            @RequestBody CitiesEntity citiesEntity) {
        return citiesService.saveCity(citiesEntity);
    }

    @GetMapping
    public List<CitiesEntity> getCitiesList() {
        return citiesService.getCitiesList();
    }

    @GetMapping("/{city_id}")
    public CitiesEntity getCityById(
            @PathVariable Long city_id) {
        return citiesService.getCityById(city_id);
    }

    @GetMapping("/delete/{city_id}")
    public Long deleteCity(
            @PathVariable Long city_id) {
        return citiesService.deleteCity(city_id);
    }

    @GetMapping("/airports/{city_id}")
    public List<AirportData> findAirportByCountry(
            @PathVariable Long city_id) throws IOException {
        CitiesEntity city = citiesService.getCityById(city_id);
        return citiesService.findAirportByCountry(city);
    }
}
