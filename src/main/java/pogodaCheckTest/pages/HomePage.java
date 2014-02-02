package pogodaCheckTest.pages;

public interface HomePage{

    void searchTown(String town);

    Boolean checkTownOnHomePage(String town);

    void checkCurrentWeather();

    void checkTown(String town);

    void changeTown();

    void checkCurrentTemperature();

    void checkNextTimeTemperature();

    void checkDetailedWeatherInfo();

    void checkFutureWeather(String period);
}
