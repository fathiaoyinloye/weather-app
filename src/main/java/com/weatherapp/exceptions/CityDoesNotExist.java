package com.weatherapp.exceptions;

public class CityDoesNotExist extends RuntimeException {
    public CityDoesNotExist(String message) {
        super(message);
    }
}
