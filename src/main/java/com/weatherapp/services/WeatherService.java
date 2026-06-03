package com.weatherapp.services;

import com.weatherapp.dtos.openWeatherResponses.OpenWeatherResponse;
import com.weatherapp.dtos.responses.GetWeatherResponse;
import com.weatherapp.exceptions.CityDoesNotExist;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;

    public WeatherService(RestClient restClient) {
        this.restClient = restClient;
    }

    public GetWeatherResponse fetchWeather(String city) {
        String apiKey = "your_key";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + ",NG&appid=" + "094c577086ceee02e928fa3374fda953" + "&units=metric";

        // 1. Fetch the data into the "External" classes
        OpenWeatherResponse externalData = restClient.get()
                .uri(url)
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {

                    throw new CityDoesNotExist("The city '" + city + "' was not found.");
                })
                .body(OpenWeatherResponse.class);

        GetWeatherResponse myResponse = new GetWeatherResponse();

        myResponse.setCity(externalData.getName());
        myResponse.setTemperature(externalData.getMain().getTemp() + "°C");
        myResponse.setHumidity(externalData.getMain().getHumidity() + "%");

        if (externalData.getWeather() != null && !externalData.getWeather().isEmpty()) {
            myResponse.setDescription(externalData.getWeather().getFirst().getDescription());
        }
        return myResponse;
    }



}
