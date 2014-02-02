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

import java.util.NoSuchElementException;

public class SearchStepsImpl extends ScenarioSteps {

    CommonPage commonPage;
    HomePage homePage;
    ResultPage resultPage;

    public SearchStepsImpl(Pages pages) {
        super(pages);
        commonPage = getPages().get(CommonPageImpl.class);
        homePage = getPages().get(HomePageImpl.class);
        resultPage = getPages().get(ResultPageImpl.class);
    }

    @Step
    public void searchTown(String town) {
        homePage.searchTown(town);
        if(!homePage.checkTownOnHomePage(town)){
            if(resultPage.checkNotNullResults()){
                resultPage.checkResults(town);
            }else System.err.println("There is no " + town + "in the search");
        }
    }

    @Step
    public void checkCurrentTown(String town) {
        if(commonPage.getCurrentUrl().contains("/search/")){
            if(resultPage.checkNotNullResults()){
                resultPage.chooseTown(town);
            }else throw new NoSuchElementException("There is no " + town + " in the search");

        }
        homePage.checkTown(town);
    }

    @Step
    public void checkNullResult() {
        resultPage.checkNotNullResults();
    }

    @Step
    public void changeTown(String town) {
        homePage.changeTown();
        resultPage.chooseTown(town);
        homePage.checkTown(town);
    }
}
