package Backend.Weather.controller;

import Backend.Weather.payload.WeatherDto;
import Backend.Weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static Backend.Weather.utils.Util.getCurrentDate;

@RestController
@RequestMapping("/api")
public class WeatherController {


    private WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    final String currentDate = getCurrentDate();

    @GetMapping("/weather")
    public WeatherDto getWeather(@RequestParam(name = "location") String location, @RequestParam(name = "startDate", required = false) String startDate, @RequestParam(name = "endDate", required = false) String endDate) throws Exception {

        if (startDate == null) startDate = currentDate;
        if (endDate == null) endDate = currentDate;

        return service.getWeather(location, startDate, endDate);
    }


}
