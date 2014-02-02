package pogodaCheckTest.jbehave.stepDefinition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import pogodaCheckTest.steps.CheckWeatherStepsImpl;

public class CheckWeatherSteps {


    @Steps
    CheckWeatherStepsImpl checkWeatherSteps;

    @Then("I see todays weather$")
    public  void i_see_todays_weather (){
        checkWeatherSteps.checkCurrentWeather();
    }

    @Then ("I see current temperature")
    public  void i_see_current_temperature (){
        checkWeatherSteps.checkCurrentTemperature();
    }
}
