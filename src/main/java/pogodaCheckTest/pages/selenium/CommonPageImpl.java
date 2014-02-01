package pogodaCheckTest.pages.selenium;

import org.openqa.selenium.WebDriver;
import pogodaCheckTest.pages.CommonPage;
import static org.junit.Assert.*;
import ru.yandex.qatools.htmlelements.thucydides.BlockPageObject;


public class CommonPageImpl extends BlockPageObject implements CommonPage {

    WebDriver  driver;

    public CommonPageImpl(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public void navigate(String url) {
        driver.get(url);
        assertTrue(driver.getCurrentUrl().contains(url));
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
