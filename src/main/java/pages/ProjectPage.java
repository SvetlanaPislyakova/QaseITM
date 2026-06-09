package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage extends BasePage {

    private final SelenideElement TITLE = $(withText("repository"));

    @Override
    public BasePage openPage() {
        return null;
    }

    @Override
    public ProjectPage isPageOpened() {
        TITLE.shouldBe(visible);
        return this;
    }

    public String getTitle() {
        return TITLE.getText();
    }
}
