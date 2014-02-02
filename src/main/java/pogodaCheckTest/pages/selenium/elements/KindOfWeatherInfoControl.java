package pogodaCheckTest.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

public class KindOfWeatherInfoControl extends HtmlElement{

    @FindBy(css = "img.b-ico_type_short")
    private Link shortWeather;

    @FindBy(css = "img.b-ico_type_full")
    private Link detailsWeather;

    @FindBy(css = "img.b-ico_type_klim")
    private Link climate;

    public void getFutureWeather(String period) {
        switch (period){
            case ("short"):
                shortWeather.click();
                break;
            case ("detailed"):
                detailsWeather.click();
                break;
            case ("climate"):
                climate.click();
                break;
        }

    }


}
