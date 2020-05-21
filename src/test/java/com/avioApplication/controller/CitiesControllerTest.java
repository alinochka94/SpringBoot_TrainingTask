package com.avioApplication.controller;

import com.avioApplication.entity.CitiesEntity;
import com.avioApplication.services.CitiesService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Controller;

import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

@Controller
class CitiesControllerTest {

    @InjectMocks
    CitiesController citiesController;

    @Mock
    CitiesService citiesService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSaveCity() {
        CitiesEntity citiesEntity = new CitiesEntity(45L, "Rome", "Italy");
        when(citiesService.saveCity(citiesEntity)).thenReturn(citiesEntity);
        CitiesEntity returned = citiesController.saveCity(citiesEntity);
        assertEquals(citiesEntity, returned);
    }

    @Test
    void testGetCitiesList() {
        when(citiesService.getCitiesList()).thenReturn(null);
        List<CitiesEntity> returned = citiesController.getCitiesList();
        assertEquals(null, returned);
    }

    @Test
    void testGetCityById() {
        CitiesEntity citiesEntity = new CitiesEntity(2L, "London", "UK");
        when(citiesService.getCityById(2L)).thenReturn(citiesEntity);
        CitiesEntity returned = citiesController.getCityById(2L);
        assertEquals(citiesEntity, returned);
    }

    @Test
    void testDeleteCity() {
        CitiesEntity citiesEntity = new CitiesEntity(3L, "Hong Kong", "China");
        when(citiesService.deleteCity(3L)).thenReturn(3L);
        when(citiesService.getCitiesList()).thenReturn(null);
        Long returned = citiesController.deleteCity(3L);
        assertEquals(citiesEntity.getCity_id(), returned);
    }

    @Test
    void testFindAirportByCountry() {
    }

    @Test
    void testFindAirports() {
    }
}