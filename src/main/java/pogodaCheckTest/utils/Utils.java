package pogodaCheckTest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.thucydides.BlockPageObject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Utils{


    public static void waitUntilelementWillAppear(WebDriver driver, TypifiedElement element) {
        element.getWrappedElement();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element.getWrappedElement()));

    }

    public static void waitUntilelementWillAppear(WebDriver driver, HtmlElement element) {
        element.getWrappedElement();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element.getWrappedElement()));

    }

    public static void waitUntilTextWillAppear(WebDriver driver, TypifiedElement element, String text) {
        element.getWrappedElement();
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(element.getWrappedElement(), text));

    }

    public static void checkTextInElement(TypifiedElement element, String text) {
        assertThat(element.getWrappedElement().getText(), is(text));
    }

    public static void assertThatStringsTheSame (String first, String second){
        assertThat(first, is(second));

    }

    public static void assertThatStringsContainSecond (String first, String second){
        assertTrue(first.contains(second));

    }

    public static void assertThatItsTrue (Boolean parameter){
        assertTrue(parameter);

    }

    public static void checkFutureDates(List<WebElement> futureDates){
        for (int i = 0; i < futureDates.size(); i++ ){
            Utils.assertThatItsTrue(futureDates.get(i).getText()
                    .contains(getNextDate(i+1)));}
    }

    private static String getNextDate(int day){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));

    }

}
