package Backend.Weather.service.impl;

import Backend.Weather.payload.WeatherDto;
import Backend.Weather.external.ThirdParty;
import Backend.Weather.service.WeatherService;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    private ThirdParty thirdParty;

    public WeatherServiceImpl(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

    @Override
    public WeatherDto getWeather(String location, String startData, String endData) throws Exception {

        return thirdParty.call(location,startData,endData);
    }
}
