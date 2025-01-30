package design_patterns.proxy;

// 클라이언트는 WeatherService 인터페이스에만 의존한다.
public interface WeatherService {
    String getWeather(String location);
}