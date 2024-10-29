package Backend.Weather.external.impl;

import Backend.Weather.exception.InvalidDateRangeException;
import Backend.Weather.mapper.WeatherMapper;
import Backend.Weather.payload.WeatherDto;
import Backend.Weather.external.ThirdParty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static Backend.Weather.utils.Util.*;


@Component
public class ThirdPartyImpl implements ThirdParty {

    @Value("${api.key}")
    private String API_KEY;


    private String urlCreation(String location, String startDate, String endDate) {

        return String.format("%s/%s/%s/%s?key=%s", BASE_URL, location, startDate, endDate, API_KEY);
    }

    private WeatherDto sendRequest(String location, String startData, String endData) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlCreation(location, startData, endData)))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception exception) {

            throw new RuntimeException();
        }


        return WeatherMapper.mapToWeather(response.body());
    }


    @Override
    public WeatherDto call(String location, String startData, String endData) throws Exception {


        if (validateDateRange(startData, endData))
            return sendRequest(location, startData, endData);
        else
            throw new InvalidDateRangeException(startData, endData);
    }
}
