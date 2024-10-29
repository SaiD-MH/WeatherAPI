package Backend.Weather.mapper;

import Backend.Weather.payload.WeatherDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class WeatherMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static WeatherDto mapToWeather(String response) {


        try {

            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(response, WeatherDto.class);

        } catch (Exception exception) {
            System.err.print(Arrays.toString(exception.getStackTrace()));

        }

        return null;

    }


}
