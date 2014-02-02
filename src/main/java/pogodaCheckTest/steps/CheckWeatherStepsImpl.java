package pogodaCheckTest.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import pogodaCheckTest.pages.CommonPage;
import pogodaCheckTest.pages.HomePage;
import pogodaCheckTest.pages.ResultPage;
import pogodaCheckTest.pages.selenium.CommonPageImpl;
import pogodaCheckTest.pages.selenium.HomePageImpl;
import pogodaCheckTest.pages.selenium.ResultPageImpl;


public class CheckWeatherStepsImpl extends ScenarioSteps {

    CommonPage commonPage;
    HomePage homePage;
    ResultPage resultPage;

    public CheckWeatherStepsImpl(Pages pages) {
        super(pages);
        commonPage = getPages().get(CommonPageImpl.class);
        homePage = getPages().get(HomePageImpl.class);
        resultPage = getPages().get(ResultPageImpl.class);
    }



    @Step
    public void checkCurrentWeather() {
        homePage.checkCurrentWeather();

    }

    @Step
    public void checkCurrentTemperature() {
        homePage.checkCurrentTemperature();
    }

    @Step
    public void checkNextTimeTemperature() {
        homePage.checkNextTimeTemperature();
    }

    @Step
    public void checkDetailedWeatherInfo() {
        homePage.checkDetailedWeatherInfo();
    }

    @Step
    public void checkFutureWeather(String period) {
        homePage.checkFutureWeather(period);
    }
}
