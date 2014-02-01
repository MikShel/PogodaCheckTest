package pogodaCheckTest.pages.selenium;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.pages.ResultPage;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.thucydides.BlockPageObject;

@DefaultUrl("http://pogoda.yandex.by/search/")
public class ResultPageImpl extends BlockPageObject implements ResultPage{

    @FindBy(css = "table.l-layout")
    private Table townResults;

    @FindBy(css = "a.b-link.b-link_type_with-temperature")
    private Link townLink;

    WebDriver driver;
    public ResultPageImpl(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public void checkResults(String town) {
        Utils.waitUntilelementWillAppear(driver,townResults);
        Utils.assertThatStringsContainSecond(townLink.getReference().toString(), "/" + town.toLowerCase());
    }

    @Override
    public Boolean checkNotNullResults() {
        Utils.waitUntilelementWillAppear(driver,townResults);
        if (townResults.getRowsAsString().get(0).get(0).isEmpty()){
            return false;
        }else return true;

    }

    @Override
    public void chooseTown() {
        townLink.click();
    }

    @Override
    public void checkNullResults() {
        Utils.assertThatItsTrue(!checkNotNullResults());
    }
}
