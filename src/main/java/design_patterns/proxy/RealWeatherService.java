package design_patterns.proxy;

import java.util.Random;

// 실제로 외부 API를 호출하는 역할
public class RealWeatherService implements WeatherService {

    @Override
    public String getWeather(String location) {
        /*
        이 부분에서 API 요청이 발생한다고 가정
         */
        System.out.println("Fetching weather data from API for: " + location);
        return "Weather in " + location + ": " + (new Random().nextInt(20) + 10) + "°C";
    }
}