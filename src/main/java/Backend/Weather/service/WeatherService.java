package Backend.Weather.service;

import Backend.Weather.payload.WeatherDto;

public interface WeatherService {



    WeatherDto getWeather(String location , String startData , String endData) throws Exception;


}
