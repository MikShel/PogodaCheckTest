package pogodaCheckTest.pages.selenium;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.pages.ResultPage;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.thucydides.BlockPageObject;

import java.util.List;

@DefaultUrl("http://pogoda.yandex.by/search/")
@NamedUrls(
        {
                @NamedUrl(name = "search", url = "/search/"),
                @NamedUrl(name = "choose", url = "/choose/"),
        })

public class ResultPageImpl extends BlockPageObject implements ResultPage{

    @FindBy(css = "table.l-layout")
    private Table townResults;

    @FindBy(css = "a.b-link.b-link_type_with-temperature")
    private List<Link> townLinks;

    WebDriver driver;
    public ResultPageImpl(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public void checkResults(String town) {
        Utils.waitUntilelementWillAppear(driver,getTown(town));
    }

    @Override
    public Boolean checkNotNullResults() {
        Utils.waitUntilelementWillAppear(driver,townResults);
        if (townResults.getRowsAsString().get(0).get(0).isEmpty()){
            return false;
        }else return true;

    }

    @Override
    public void chooseTown(String town) {
        Utils.waitUntilelementWillAppear(driver, townResults);
        getTown(town).click();
    }

    @Override
    public void checkNullResults() {
        Utils.waitUntilelementWillAppear(driver, townResults);
        Utils.assertThatItsTrue(!checkNotNullResults());
    }

    private Link getTown (String town){
        Utils.waitUntilelementWillAppear(driver, townResults);
        for (Link townLink: townLinks){
            if (townLink.getText().contains(town)){
                return townLink;
            }
        }
        return null;
    }
}
