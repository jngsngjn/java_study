package design_patterns.proxy;

public class WeatherClient {

    private final WeatherService weatherService;

    public WeatherClient(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String requestWeather(String location) {
        return weatherService.getWeather(location);
    }
}