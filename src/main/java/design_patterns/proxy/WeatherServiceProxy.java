package design_patterns.proxy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WeatherServiceProxy implements WeatherService {

    private final RealWeatherService realWeatherService;

    public WeatherServiceProxy(RealWeatherService realWeatherService) {
        this.realWeatherService = realWeatherService;
    }

    // 캐시 저장소
    private final Map<String, String> cache = new ConcurrentHashMap<>();

    @Override
    public String getWeather(String location) {
        // 1. 캐시에서 먼저 확인
        if (cache.containsKey(location)) {
            System.out.println("[CACHE] Returning cached weather data for: " + location);
            return cache.get(location);
        }

        // 2. API 호출 (실제 객체 호출)
        System.out.println("[LOG] API Request -> " + location);
        String weatherData = realWeatherService.getWeather(location);

        // 3. 응답을 캐시에 저장
        cache.put(location, weatherData);

        return weatherData;
    }
}