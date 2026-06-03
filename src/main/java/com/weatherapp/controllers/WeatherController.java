package com.weatherapp.controllers;

import com.weatherapp.dtos.responses.GetWeatherResponse;
import com.weatherapp.services.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/{city}")
    public ResponseEntity<GetWeatherResponse> getWeather(@PathVariable  String city) {
        return ResponseEntity.ok(weatherService.fetchWeather(city));
    }
}
