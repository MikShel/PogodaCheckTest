package pogodaCheckTest.pages.selenium.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.List;

public class CurrentWeather extends HtmlElement {

    @FindBy(css = "div.b-thermometer__now")
    private TextBlock temperatureNow;

    @FindBy(css = "table.l-layout_layout_current-weather")
    private Table currentWeather;

    public String getCurrentTemperature() {
        return temperatureNow.getText();
    }

    public void checkCurentWeatherResultsExist(){
        Utils.assertThatItsTrue(currentWeather.getRows().get(0).size() >= 6);
    }

    public void checkNextTimeTemperatureExist() {
        List<WebElement> rows = currentWeather.getRows().get(0);
        if(rows.size() > 6){
            for (int i = 4; i < rows.size()-2; i++){
                Utils.assertThatItsTrue(rows.get(i).getText().contains("днем") || rows.get(i).getText().contains("вечером")
                        || rows.get(i).getText().contains("ночью"));
            }
        }
    }

    public void checkDetailedWeatherInfo() {
        List<WebElement> rows = currentWeather.getRows().get(0);
        WebElement details = currentWeather.getRows().get(0).get(rows.size()-2);
        Utils.assertThatItsTrue(details.getText().contains("Давление")
                & details.getText().contains("Ветер")
                    & details.getText().contains("Влажность")
                        & details.getText().contains("Восход"));
    }

}
