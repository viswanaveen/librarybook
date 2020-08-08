package com.naveen.librarybook.controller;

import com.naveen.librarybook.model.Library;
import com.naveen.librarybook.model.Root;
import com.naveen.librarybook.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("{countryName}/{key}")
    public double getBookCategoryById(@PathVariable String countryName, @PathVariable String key) {
        Root root = weatherReportService.getWeatherReport(countryName,key);
        return root.getMain().getTemp();

    }
}
