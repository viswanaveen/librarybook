package com.naveen.librarybook.client;

import com.naveen.librarybook.model.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "weather",
        url = "http://api.openweathermap.org/data/2.5"
        )
public interface WeatherFeignClient {

    @GetMapping("/weather?q={countryName}&appid={key}")
    public ResponseEntity<Root> getWetherReport(@PathVariable("countryName") String countryName,
                                                @PathVariable("key") String key);
}
