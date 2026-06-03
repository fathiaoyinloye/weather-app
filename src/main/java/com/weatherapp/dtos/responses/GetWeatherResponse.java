package com.weatherapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetWeatherResponse {

    private String temperature;
    private String humidity;
    private String description;
    private String city;
}
