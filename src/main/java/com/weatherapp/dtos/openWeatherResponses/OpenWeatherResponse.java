package com.weatherapp.dtos.openWeatherResponses;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse {
    private String name;
    private Main main;
    private List<WeatherDescription> weather;
}