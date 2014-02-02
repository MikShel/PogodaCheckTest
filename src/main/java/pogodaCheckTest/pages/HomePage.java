package pogodaCheckTest.pages;

public interface HomePage{

    public void searchTown(String town);

    public Boolean checkTownOnHomePage(String town);

    public void checkCurrentWeather();

    public void checkTown(String town);

    void changeTown();

    void checkCurrentTemperature();
}
