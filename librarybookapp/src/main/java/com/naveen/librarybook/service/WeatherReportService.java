package com.naveen.librarybook.service;

import com.naveen.librarybook.client.WeatherFeignClient;
import com.naveen.librarybook.model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportService {

    @Autowired
    private WeatherFeignClient weatherFeignClient;

    public Root getWeatherReport(String countryName ,String key) {
        try {
            ResponseEntity<Root> rootResponse = null;
            rootResponse = weatherFeignClient.getWetherReport(countryName, key);
            return rootResponse.getBody();
        }catch(Exception e) {
            throw new RuntimeException("Failed to invoke service" +e.getMessage());
        }
    }
}
