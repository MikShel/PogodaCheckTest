package pogodaCheckTest.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class FutureWeather extends HtmlElement {

    @FindBy(css = "div.b-thermometer__now")
    private TextBlock temperatureNow;

    @FindBy(css = "table.b-forecast__layout")
    private Table futureWeatherTable;

    @FindBy(css = "table.b-forecast-detailed__data")
    private Table futureDetailedWeatherTableData;

    @FindBy(css = "div.b-forecast-climate")
    private TypifiedElement climate;

    public TypifiedElement getControlElement(String period){
        switch (period){
            case ("short"):
                return futureWeatherTable;
            case ("detailed"):
                return futureDetailedWeatherTableData;
            case ("climate"):
                return climate;
        }

        return null;
    }

    public void checkFutureWeather(String period) {
        switch (period){
            case ("short"):
                System.err.println("!!!!!!!" + futureWeatherTable.getRows().get(0).get(0).getText());
                System.err.println("!!!!!!!" + futureWeatherTable.getColumns().get(0).get(1).getText());
                break;
            case ("detailed"):
                break;
            case ("climate"):
                break;
        }

    }
}
