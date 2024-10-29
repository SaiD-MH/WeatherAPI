package Backend.Weather.external;

import Backend.Weather.payload.WeatherDto;

public interface ThirdParty {

    WeatherDto call(String location , String startData , String endData) throws Exception;

}
