package pogodaCheckTest.pages.selenium;

import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.pages.HomePage;
import pogodaCheckTest.pages.selenium.elements.CurrentWeather;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.thucydides.BlockPageObject;


@DefaultUrl("http://pogoda.yandex.ru")
public class HomePageImpl extends BlockPageObject implements HomePage {
    @FindBy(css = "input.b-form-input__input")
    private TextInput searchTextInput;

    @FindBy(css = "input.b-form-button__input")
    private Button searchButton;

    @FindBy(css = "span.b-navigation-city__city")
    private TextBlock townName;

    @FindBy(css = "div.b-widget-current-weather")
    private CurrentWeather currentWeather;

    @FindBy(css = "span.b-navigation-city__city-switcher")
    private Link changeTownLink;

    @FindBy(css = "li.b-menu_layout_vert__layout-cell_last")
    private Link changeTownSelect;

    WebDriver driver;

    public HomePageImpl(WebDriver driver) {
       super(driver);
       this.driver = driver;
    }

    @Override
    public void searchTown(String town) {
        Utils.waitUntilelementWillAppear(driver, searchTextInput);
        searchTextInput.sendKeys(town);
        searchButton.click();
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
        Utils.waitUntilelementWillAppear(driver, searchTextInput);
        Utils.assertThatStringsContainSecond(driver.getTitle(), town);
        //Utils.assertThatStringsTheSame(townName.getText(),town);
        //Utils.assertThatItsTrue(townName.isDisplayed());

    }

    @Override
    public void changeTown() {
        Utils.waitUntilelementWillAppear(driver, changeTownLink);
        changeTownLink.click();
        if (!driver.getCurrentUrl().contains("/search/") & !driver.getCurrentUrl().contains("/choose/")){
            changeTownSelect.click();
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
    public void checkCurrentWeather() {
        Utils.waitUntilelementWillAppear(driver, currentWeather);
        currentWeather.checkCurentWeatherResultsExist();
    }

}
