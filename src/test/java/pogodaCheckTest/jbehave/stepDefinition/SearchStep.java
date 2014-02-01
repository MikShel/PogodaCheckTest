package pogodaCheckTest.jbehave.stepDefinition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pogodaCheckTest.steps.SearchStepsImpl;

public class SearchStep {

    @Steps
    SearchStepsImpl searchSteps;

    @Given("I want to check weather in $town")
    public void I_want_to_check_weather_in_town(@Named("town")String town){
        searchSteps.searchTown(town);
    }

    @When("I find $town using search$")
    public void I_find_town_using_search(@Named("town")String town){
        searchSteps.searchTown(town);
        searchSteps.checkCurrentTown(town);
    }

    @Then("I am notified that it is not exist$")
    public void I_notified_that_it_not_exist(){
        searchSteps.checkNullResult();
    }

    @When("I want to change town on $town$")
    public void I_want_to_change_town(@Named("town")String town){
        searchSteps.changeTown(town);
    }
}
