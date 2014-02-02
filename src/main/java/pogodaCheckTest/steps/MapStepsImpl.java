package pogodaCheckTest.steps;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import pogodaCheckTest.pages.HomePage;
import pogodaCheckTest.pages.MapPage;
import pogodaCheckTest.pages.selenium.HomePageImpl;
import pogodaCheckTest.pages.selenium.MapPageImpl;

public class MapStepsImpl extends ScenarioSteps {

    HomePage homePage;
    MapPage mapPage;

    public MapStepsImpl(Pages pages) {
        super(pages);
        homePage = getPages().get(HomePageImpl.class);
        mapPage = getPages().get(MapPageImpl.class);
    }

    public void getMapView() {
        homePage.getMapView();
    }

    public void checkView(String kind) {
        mapPage.checkView(kind);
    }
}
