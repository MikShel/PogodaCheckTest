package pogodaCheckTest.jbehave.stepDefinition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.AsParameterConverter;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import pogodaCheckTest.steps.CommonStepsImpl;

public class CommonSteps {

    @Steps
    CommonStepsImpl commonSteps;

    @Given("Im on the $url")
    public  void im_on_current_page(String url){
        commonSteps.navigate(url);
    }

}
