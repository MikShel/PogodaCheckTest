package pogodaCheckTest.pages.selenium.elements;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.*;

public class FutureWeather extends HtmlElement {

    @FindBy(css = "div.b-thermometer__now")
    private TextBlock temperatureNow;

    @FindBy(css = "table.b-forecast__layout")
    private Table futureWeatherTable;

    @FindBy(css = "table.b-forecast-detailed__data")
    private Table futureDetailedWeatherTableData;

    @FindBy(css = "tr.b-forecast-detailed__line")
    private List<TextBlock> futureDetailedWeatherData;

    @FindBy(css = "div.b-climate-pic")
    private List<TextBlock> climate;

    public TypifiedElement getControlElement(String period){
        switch (period){
            case ("short"):
                return futureWeatherTable;
            case ("detailed"):
                return futureDetailedWeatherTableData;
            case ("climate"):
                return climate.get(0);
        }

        return null;
    }

    public void checkFutureWeather(String period) {
        switch (period){
            case ("short"):
                checkFutureDates(futureWeatherTable.getWrappedElement()
                        .findElements(By.cssSelector("th.b-forecast__item_type_head")));

                break;
            case ("detailed"):
                List<WebElement> dates = new ArrayList<WebElement>();
                for (TextBlock date : futureDetailedWeatherData){
                    if(!date.getText().isEmpty()){
                        if(!date.getText().contains(String.valueOf(Calendar.DAY_OF_MONTH))){
                            dates.add(date.getWrappedElement());
                        }
                    }
                }
                checkFutureDates(dates);
                break;
            case ("climate"):
                for (TextBlock graf : climate){
                    Utils.assertThatItsTrue(graf.getText().contains("Относительная влажность")
                            || graf.getText().contains("Число дней с осадками более 1 мм")
                            || graf.getText().contains("Количество осадков")
                            || graf.getText().contains("Температура днём")
                            || graf.getText().contains("Температура ночью"));
                }
                break;
        }

    }

    private String getNextDate(int day){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));

    }

    private void checkFutureDates(List<WebElement> futureDates){
        for (int i = 0; i < futureDates.size(); i++ ){
            Utils.assertThatItsTrue(futureDates.get(i).getText()
                    .contains(getNextDate(i+1)));}
    }


}
