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

public class CommonStepsImpl extends ScenarioSteps {

    CommonPage commonPage;
    HomePage homePage;
    ResultPage resultPage;

    public CommonStepsImpl(Pages pages) {
        super(pages);
        commonPage = getPages().get(CommonPageImpl.class);
    }

    @Step
    public void navigate(String url) {
        commonPage.navigate(url);

    }

}
