package pogodaCheckTest.jbehave.stepDefinition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pogodaCheckTest.steps.MapStepsImpl;

public class MapSteps {

    @Steps
    MapStepsImpl mapSteps;

    @When("I choose weather on map")
    public void i_choose_weather_on_map(){
        mapSteps.getMapView();
    }

    @Then ("I can see map $kind view")
    public void i_can_see_map_view(@Named("kind")String kind){
        mapSteps.checkView(kind);
    }
}
