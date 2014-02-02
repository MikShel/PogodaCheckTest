package pogodaCheckTest.pages.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.pages.ClimatePage;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.thucydides.BlockPageObject;

import java.util.List;

public class ClimatePageImpl extends BlockPageObject implements ClimatePage{

    @FindBy(css = "div.b-climate-pic")
    private List<TextBlock> climate;

    WebDriver driver;

    public ClimatePageImpl(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @Override
    public void checkClimate(){
        Utils.waitUntilelementWillAppear(driver, climate.get(0));
        for (TextBlock graf : climate){
            Utils.assertThatItsTrue(graf.getText().contains("Относительная влажность")
                    || graf.getText().contains("Число дней с осадками более 1 мм")
                    || graf.getText().contains("Количество осадков")
                    || graf.getText().contains("Температура днём")
                    || graf.getText().contains("Температура ночью"));
        }
    }
}
