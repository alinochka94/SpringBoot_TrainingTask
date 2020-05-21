package com.avioApplication.services;

import com.avioApplication.entity.CitiesEntity;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CitiesServiceTest {

    @Autowired
    private CitiesService citiesService;

    @Test
    void testGetCitiesList() {
        List<CitiesEntity> city = citiesService.getCitiesList();
        assertEquals(city.size(), 9);
    }

    @Test
    void testGetCityById() {
        CitiesEntity city1 = citiesService.getCityById(1L);
        CitiesEntity city2 = citiesService.getCityById(4L);

        assertEquals(city1.getCity_name(), "Riga");
        assertEquals(city1.getCountry_name(), "Latvia");

        assertEquals(city2.getCity_name(), "Brazil");
        assertEquals(city2.getCountry_name(), "Brazil");
    }

    @Test
    void testSaveCity() {
        CitiesEntity city1 = new CitiesEntity(43L, "Vilnus", "Lithuania");
        CitiesEntity city2 = new CitiesEntity(44L, "Berlin", "Germany");

        CitiesEntity savedCity1 = citiesService.saveCity(city1);
        CitiesEntity savedCity2 = citiesService.saveCity(city2);

        assertEquals(city1.getCity_id(), savedCity1.getCity_id());
        assertEquals(city1.getCity_name(), savedCity1.getCity_name());
        assertEquals(city1.getCountry_name(), savedCity1.getCountry_name());

        assertEquals(city2.getCity_id(), savedCity2.getCity_id());
        assertEquals(city2.getCity_name(), savedCity2.getCity_name());
        assertEquals(city2.getCountry_name(), savedCity2.getCountry_name());
    }

    @Test
    void testDeleteCity() {
        Long id = citiesService.deleteCity(44L);
        assertEquals(id, 44L);
    }

    @Test
    void testFindAirports() throws IOException {
    }

    @Test
    void testFindAirportByCountry() {

    }
}