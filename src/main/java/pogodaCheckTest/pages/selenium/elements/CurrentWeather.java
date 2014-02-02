package pogodaCheckTest.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class CurrentWeather extends HtmlElement {

    @FindBy(css = "div.b-thermometer__now")
    public TextBlock temperatureNow;

    @FindBy(css = "table.l-layout_layout_current-weather")
    public Table currentWeather;

    public String getTemperature() {
        return temperatureNow.getText();
    }

    public void checkCurentWeatherResultsExist(){
        System.err.println("!!!!!!!!!!!" + currentWeather.getColumns().size());
        Utils.assertThatItsTrue(currentWeather.getColumns().size() >= 2);
    }

}
