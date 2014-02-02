package pogodaCheckTest.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

public class MapRegion extends HtmlElement {

    @FindBy(css = "span.b-dropdowna__switcher")
    private Link selectViewLink;

    @FindBy(css = "div.YMaps-slider")
    private HtmlElement slider;

    @FindBy(css = "div.YMaps-button")
    private List<Button> changeMap;

    @FindBy(css = "div.b-maps-monitor__viewport")
    private HtmlElement map;

    public void checkView(String view){
        Utils.assertThatStringsTheSame(selectViewLink.getText(),view);
    }


    public void checkMap() {
        slider.isDisplayed();
        map.isDisplayed();
    }
}
