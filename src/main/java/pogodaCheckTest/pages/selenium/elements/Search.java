package pogodaCheckTest.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class Search extends HtmlElement{

    @FindBy(css = "input.b-form-input__input")
    private TextInput searchTextInput;

    @FindBy(css = "input.b-form-button__input")
    private Button searchButton;

    public void search(String town) {
        searchTextInput.sendKeys(town);
        searchButton.click();
    }


}
