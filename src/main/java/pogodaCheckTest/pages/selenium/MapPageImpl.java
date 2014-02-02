package pogodaCheckTest.pages.selenium;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.pages.MapPage;
import pogodaCheckTest.pages.selenium.elements.MapRegion;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.thucydides.BlockPageObject;

import java.util.List;

public class MapPageImpl extends BlockPageObject implements MapPage {

    @FindBy(css = "td.l-page__right")
    private MapRegion mapRegion;


    WebDriver driver;

    public MapPageImpl(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }


    @Override
    public void checkView(String kind) {
        Utils.waitUntilelementWillAppear(driver, mapRegion);
        mapRegion.checkView(kind);
        mapRegion.checkMap();
    }
}
