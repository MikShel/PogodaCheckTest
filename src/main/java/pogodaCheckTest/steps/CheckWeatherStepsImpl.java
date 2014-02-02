package pogodaCheckTest.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import pogodaCheckTest.pages.*;
import pogodaCheckTest.pages.selenium.*;


public class CheckWeatherStepsImpl extends ScenarioSteps {

    CommonPage commonPage;
    HomePage homePage;
    ResultPage resultPage;
    ClimatePage climatePage;
    DetailsPage detailsPage;

    public CheckWeatherStepsImpl(Pages pages) {
        super(pages);
        commonPage = getPages().get(CommonPageImpl.class);
        homePage = getPages().get(HomePageImpl.class);
        resultPage = getPages().get(ResultPageImpl.class);
        climatePage = getPages().get(ClimatePageImpl.class);
        detailsPage = getPages().get(DetailsPageImpl.class);
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
    public void checkFutureWeather(String period) {
        switch (period){
            case "short":
                homePage.chooseKindOfDetails(period);
                homePage.checkFutureWeather();
                break;
            case "detailed":
                homePage.chooseKindOfDetails(period);
                detailsPage.checkDetailedWeatherInfo();
                break;
        }
    }

    @Step
    public void checkDetailedCurrentWeatherInfo() {
        homePage.checkDetailedWeatherInfo();
    }

    @Step
    public void checkClimate() {
        homePage.chooseKindOfDetails("climate");
        climatePage.checkClimate();
    }
}
