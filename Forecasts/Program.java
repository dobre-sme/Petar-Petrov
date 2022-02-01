package com.company;


import com.company.src.ForecastStreamRepository;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        ForecastRepository forecastRepository = new ForecastRepository();
        ForecastStreamRepository forecastStreamRepository = new ForecastStreamRepository();
        Forecast forecast1 = new Forecast(12.4, 14.5, 22.4, 18.9,
                27, 21, 32,
                18.5, 22.4, 19.2);
        Forecast forecast2 = new Forecast(22.4, 24.5, 32.4, 38.9,
                37, 89, 35,
                38.5, 32.4, 39.2);
        Forecast forecast3 = new Forecast(22.4, 24.5, 42.4, 48.9,
                89, 89, 52,
                48.5, 42.4, 49.2);
        forecastStreamRepository.addForecast(forecast1);
        forecastStreamRepository.addForecast(forecast2);
        forecastStreamRepository.addForecast(forecast3);

    }
}
