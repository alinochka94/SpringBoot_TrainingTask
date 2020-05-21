package com.avioApplication.services;

import com.avioApplication.controller.CitiesController;
import com.avioApplication.entity.AirportData;
import com.avioApplication.entity.AirportsEntity;
import com.avioApplication.entity.CitiesEntity;
import com.avioApplication.repository.CitiesRepository;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CitiesService {
    @Autowired
    private CitiesRepository citiesRepository;

    private final static Logger logger = (Logger) LoggerFactory.getLogger(CitiesController.class);

    public List<CitiesEntity> getCitiesList () {
        List<CitiesEntity> citiesEntities = new ArrayList<CitiesEntity>();
        citiesRepository.findAll().forEach(city -> citiesEntities.add(city));
        return citiesEntities;
    }

    public CitiesEntity getCityById (Long city_id) {
        return citiesRepository.findById(city_id)
               .orElseThrow(() -> new EntityNotFoundException("Could not find City with city_name=" + city_id));
    }

    public CitiesEntity saveCity (CitiesEntity city) {
        return citiesRepository.save(city);
    }

    public Long deleteCity(Long city_id)
    {
        citiesRepository.deleteById(city_id);
        return city_id;
    }

    public List<AirportData> findAirports () throws IOException {
        String apiKey = "516a9a8b15bf5b83c40022cce82f6eab";

        URL url = new URL("http://api.aviationstack.com/v1/airports?access_key=" + apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        AirportsEntity result = new AirportsEntity();
        if(connection.getResponseCode() == 200) {
            BufferedReader json  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            result = new Gson().fromJson(json, AirportsEntity.class);
        }
        return result.getData();
    }

    public List<AirportData> findAirportByCountry (CitiesEntity city) throws IOException {
        String apiKey = "516a9a8b15bf5b83c40022cce82f6eab";

        URL url = new URL("http://api.aviationstack.com/v1/airports?access_key=" + apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        AirportsEntity result = new AirportsEntity();
        if(connection.getResponseCode() == 200) {
            BufferedReader json  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            result = new Gson().fromJson(json, AirportsEntity.class);
        }
        List<AirportData> filteredList = new ArrayList<>();
        String cityCountry = city.getCountry_name();

        for (AirportData airport : result.getData()){
            String airportCountry = airport.getCountry_name();

            if (airportCountry != null && airportCountry.equals(cityCountry)){
                filteredList.add(airport);
            }
        }
        return filteredList;
    }


}
