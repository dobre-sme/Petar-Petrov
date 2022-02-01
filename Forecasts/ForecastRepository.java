package com.company;

import java.util.ArrayList;
import java.util.List;

public class ForecastRepository {
    private List<Forecast> forecasts;

    public ForecastRepository() {
        this.forecasts = new ArrayList<>();
    }

    public void addForecast(Forecast forecast) {
        this.forecasts.add(forecast);
    }

    public List<Forecast> getAllForSpecificLongitudeAndLatitude(double longitude, double latitude) {
        List<Forecast> resultForecasts = new ArrayList<>();
        for (Forecast forecast : this.forecasts) {
            if (forecast.getLongitude() == longitude && forecast.getLatitude() == latitude) {
                resultForecasts.add(forecast);
            }
        }
        return resultForecasts;
    }

    public List<Forecast> getAllForLongitudeAndLatitudeRange(double minLongitude, double maxLongitude, double minLatitude, double maxLatitude) {
        List<Forecast> resultForecast = new ArrayList<>();
        for (Forecast forecast : this.forecasts) {
            if (forecast.getLongitude() >= minLatitude && forecast.getLongitude() <= maxLongitude
                    && forecast.getLatitude() >= minLatitude && forecast.getLatitude() <= maxLatitude) {
                resultForecast.add(forecast);
            }
        }
        return resultForecast;
    }

    public List<Forecast> getAllWhereRainChanceIsMoreThan50Percent() {
        List<Forecast> resultForecast = new ArrayList<>();
        for (Forecast forecast : this.forecasts) {
            if (forecast.getRainChancePercentage() > 50) {
                resultForecast.add(forecast);
            }
        }
        return resultForecast;
    }

    public List<Forecast> getAllWhereSnowChanceIsMoreThan25PercentAndRainChanceIsMoreThan75Percent() {
        List<Forecast> resultForecast = new ArrayList<>();
        for (Forecast forecast : this.forecasts) {
            if (forecast.getSnowChancePercentage() > 25 && forecast.getRainChancePercentage() > 75) {
                resultForecast.add(forecast);
            }
        }
        return resultForecast;
    }

    public List<Forecast> getAllWhereRainChanceIsMoreThan85PercentAndThunderstormChanceIsMoreThan50Percent() {
        List<Forecast> resultForecast = new ArrayList<>();
        for (Forecast forecast : this.forecasts) {
            if (forecast.getRainChancePercentage() > 85 && forecast.getThunderstormPercentage() > 50) {
                resultForecast.add(forecast);
            }
        }
        return resultForecast;
    }

    public List<Forecast> getAllWhereWindVelocityIsInRange(double minVelocity, double maxVelocity) {
        List<Forecast> resultForecast = new ArrayList<>();
        for (Forecast forecast : this.forecasts) {
            if (forecast.getWindVelocityInKilometersPerHour() >= minVelocity
                    && forecast.getWindVelocityInKilometersPerHour() <= maxVelocity) {
                resultForecast.add(forecast);
            }
        }
        return resultForecast;
    }

    public List<Double> getHumidityOfAreasInRangeOfAnAreaThatHasMoreThan85PercentChanceOfRain(double deltaLongitude, double deltaLatitude) {
        List<Double> result = new ArrayList<>();
        for (Forecast forecast : this.forecasts) {
            if (forecast.getRainChancePercentage() == 89
                    && forecast.getLongitude() >= deltaLongitude - 10
                    && forecast.getLongitude() <= deltaLongitude + 10
                    && forecast.getLatitude() >= deltaLatitude - 10
                    && forecast.getLatitude() <= deltaLatitude + 10) {
                result.add(forecast.getHumidity());
            }
        }
        return result;
    }

    public List<Double> getFeelsLikeOfAreasInRangeOfAnAreaThatHasMoreThan85PercentChanceOfSnow(double deltaLongitude, double deltaLatitude) {
        List<Double> resultDoubles = new ArrayList<>();
        for (Forecast forecast : this.forecasts) {
            if (forecast.getSnowChancePercentage() == 89
                    && forecast.getLongitude() >= deltaLongitude - 10
                    && forecast.getLongitude() <= deltaLongitude + 10
                    && forecast.getLatitude() >= deltaLatitude - 10
                    && forecast.getLatitude() <= deltaLatitude + 10) {
                resultDoubles.add(forecast.getTemperatureFeelsLike());
            }
        }
        return resultDoubles;
    }

    public Double getAverageFeelsLikeTemperatureForSpecificRangeOfLongitudeAndLatitude(double minLongitude, double maxLongitude,
                                                                                             double minLatitude, double maxLatitude) {
        List<Double> resultList = new ArrayList<>();
        for (Forecast forecast : this.forecasts) {
            if (forecast.getLongitude() >= minLongitude && forecast.getLongitude() <= maxLongitude
            && forecast.getLatitude() >= minLatitude && forecast.getLatitude() <= maxLatitude) {
                resultList.add(forecast.getTemperatureFeelsLike());
            }
        }
        double result = 0.0;
        for (Double feelsLikeTemp : resultList) {
            result = result + feelsLikeTemp;
        }
        return result;
    }
}

