package pogodaCheckTest.jbehave.stepDefinition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
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

    @Then ("I see next time period temperature")
    public  void i_see_next_temperature (){
        checkWeatherSteps.checkNextTimeTemperature();
    }

    @Then ("I see detailed weather info")
    public void i_see_detailed_weather_info(){
        checkWeatherSteps.checkDetailedWeatherInfo();
    }

    @Then ("I check $period future weather")
    public void i_check_future_weather(@Named("period")String period){
        checkWeatherSteps.checkFutureWeather(period);
    }

    @Then ("I check climate")
    public void i_check_climate(){
        checkWeatherSteps.checkClimate();
    }

}
