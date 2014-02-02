package pogodaCheckTest.pages.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.pages.DetailsPage;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.thucydides.BlockPageObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DetailsPageImpl extends BlockPageObject implements DetailsPage {

    @FindBy(css = "table.b-forecast-detailed__data")
    private Table futureDetailedWeatherTableData;

    @FindBy(css = "tr.b-forecast-detailed__line")
    private List<TextBlock> futureDetailedWeatherData;

    WebDriver driver;

    public DetailsPageImpl(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public void checkDetailedWeatherInfo() {
        Utils.waitUntilelementWillAppear(driver, futureDetailedWeatherTableData);
        List<WebElement> dates = new ArrayList<WebElement>();
        for (TextBlock date : futureDetailedWeatherData){
            if(!date.getText().isEmpty()){
                if(!date.getText().contains(String.valueOf(Calendar.DAY_OF_MONTH))){
                    dates.add(date.getWrappedElement());
                }
            }
        }
        Utils.checkFutureDates(dates);
    }
}
