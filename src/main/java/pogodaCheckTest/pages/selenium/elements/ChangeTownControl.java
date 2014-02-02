package pogodaCheckTest.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import pogodaCheckTest.utils.Utils;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

public class ChangeTownControl extends HtmlElement {

    @FindBy(css = "span.b-navigation-city__city-switcher")
    private Link changeTownLink;

    @FindBy(css = "li.b-menu_layout_vert__layout-cell_last")
    private Link changeTownSelect;

    public ChangeTownControl() {

    }

    public void changeTownLinkClick(){
        changeTownLink.click();
    }

    public void changeTownSelect(){
        changeTownSelect.click();
    }
}
