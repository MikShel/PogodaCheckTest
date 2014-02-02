package pogodaCheckTest.pages.selenium.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.List;

public class CurrentWeather extends HtmlElement {

    @FindBy(css = "div.b-thermometer__now")
    public TextBlock temperatureNow;

    @FindBy(css = "table.l-layout_layout_current-weather")
    public Table currentWeather;

    public String getCurrentTemperature() {
        return temperatureNow.getText();
    }

    public void checkCurentWeatherResultsExist(){
        Utils.assertThatItsTrue(currentWeather.getRows().get(0).size() >= 6);
    }

    public void checkNextTimeTemperatureExist() {
        List<WebElement> rows = currentWeather.getRows().get(0);
        for (WebElement element : rows){
            System.err.println("!!!!!!! ALLL ELEMENTS " + element.getText());
        }
        if(rows.size() > 6){
            for (int i = 4; i < rows.size()-2; i++){
                System.err.println("!!!!!!!" +rows.get(i).getText());
                Utils.assertThatItsTrue(rows.get(i).getText().contains("днем") || rows.get(i).getText().contains("вечером")
                        || rows.get(i).getText().contains("ночью"));
            }
        }
    }

    public void checkDetailedWeatherInfo() {
        List<WebElement> rows = currentWeather.getRows().get(0);
        Utils.assertThatItsTrue(rows.get(rows.size()-1).getText().contains("Давление")
                & rows.get(rows.size()-1).getText().contains("Ветер")
                    & rows.get(rows.size()-1).getText().contains("Влажность")
                        & rows.get(rows.size()-1).getText().contains("Восход"));
    }
}
