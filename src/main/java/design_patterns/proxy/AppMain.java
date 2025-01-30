package design_patterns.proxy;

public class AppMain {
    public static void main(String[] args) {
        // Client → Proxy → RealSubject 관계
        RealWeatherService realWeatherService = new RealWeatherService();
        WeatherServiceProxy weatherServiceProxy = new WeatherServiceProxy(realWeatherService);
        WeatherClient client = new WeatherClient(weatherServiceProxy);

        // 첫 번째 요청: API 호출 발생
        System.out.println(client.requestWeather("서울"));

        System.out.println();

        // 두 번째 요청: 캐싱된 데이터 사용
        System.out.println(client.requestWeather("서울"));

        System.out.println();
        System.out.println("==============================================");
        System.out.println();

        // 새로운 지역 요청: API 호출 발생
        System.out.println(client.requestWeather("부산"));

        System.out.println();

        // 다시 요청: 캐싱된 데이터 사용
        System.out.println(client.requestWeather("부산"));
    }
}