package pogodaCheckTest.pages.selenium;

import net.thucydides.core.annotations.DefaultUrl;

import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.pages.HomePage;
import pogodaCheckTest.pages.selenium.elements.ChangeTownControl;
import pogodaCheckTest.pages.selenium.elements.CurrentWeather;
import pogodaCheckTest.pages.selenium.elements.KindOfWeatherInfoControl;
import pogodaCheckTest.pages.selenium.elements.Search;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.thucydides.BlockPageObject;


@DefaultUrl("http://pogoda.yandex.ru")
public class HomePageImpl extends BlockPageObject implements HomePage {
    @FindBy(css = "div.b-head-search")
    private Search searchElement;

    @FindBy(css = "span.b-navigation-city__city")
    private TextBlock townName;

    @FindBy(css = "div.b-widget-current-weather")
    private CurrentWeather currentWeather;

    @FindBy(css = "body.b-page")
    private ChangeTownControl changeTownControl;

    @FindBy(css = "div.b-trigger-control")
    private KindOfWeatherInfoControl kindOfWeatherInfoControl;

    @FindBy(css = "table.b-forecast__layout")
    private Table futureWeatherTable;

    WebDriver driver;

    public HomePageImpl(WebDriver driver) {
       super(driver);
       this.driver = driver;
    }

    @Override
    public void searchTown(String town) {
        Utils.waitUntilelementWillAppear(driver, searchElement);
        searchElement.search(town);
    }

    @Override
    public Boolean checkTownOnHomePage(String town) {
        try{
        //return townName.getText().equals(town);
        return townName.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void checkTown(String town) {
        Utils.waitUntilelementWillAppear(driver, townName);
        Utils.assertThatStringsContainSecond(driver.getTitle(), town);
    }

    @Override
    public void changeTown() {
        Utils.waitUntilelementWillAppear(driver, changeTownControl);
        changeTownControl.changeTownLinkClick();
        if (!driver.getCurrentUrl().contains("/search/") & !driver.getCurrentUrl().contains("/choose/")){
            changeTownControl.changeTownSelect();
        }
    }

    @Override
    public void checkCurrentTemperature() {
        checkCurrentWeather();
        Utils.assertThatItsTrue(currentWeather.getCurrentTemperature().contains("°C"));
    }

    @Override
    public void checkNextTimeTemperature() {
        checkCurrentWeather();
        currentWeather.checkNextTimeTemperatureExist();
    }

    @Override
    public void checkDetailedWeatherInfo() {
        checkCurrentWeather();
        currentWeather.checkDetailedWeatherInfo();
    }

    @Override
    public void checkFutureWeather() {
        Utils.waitUntilelementWillAppear(driver, futureWeatherTable);
        Utils.checkFutureDates(futureWeatherTable.getWrappedElement()
                .findElements(By.cssSelector("th.b-forecast__item_type_head")));

    }

    @Override
    public void chooseKindOfDetails(String period) {
        Utils.waitUntilelementWillAppear(driver, kindOfWeatherInfoControl);
        kindOfWeatherInfoControl.getFutureWeather(period);
    }

    @Override
    public void checkCurrentWeather() {
        Utils.waitUntilelementWillAppear(driver, currentWeather);
        currentWeather.checkCurentWeatherResultsExist();
    }

}
