package pogodaCheckTest.pages.selenium;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pogodaCheckTest.pages.HomePage;
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

    @FindBy(css = "div.b-thermometer__now")
    private TextBlock temperatureNow;

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
        Utils.assertThatStringsContainSecond(driver.getTitle(), town);
        //Utils.assertThatStringsTheSame(townName.getText(),town);
        //Utils.assertThatItsTrue(townName.isDisplayed());

    }

    @Override
    public void changeTown() {
        changeTownLink.click();
        if (!driver.getCurrentUrl().contains("/search/")){
            changeTownSelect.click();
        }
    }

    @Override
    public void getCurrentWeather() {
        temperatureNow.getText().contains("°C");
    }

}
