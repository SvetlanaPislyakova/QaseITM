package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateNewProjectModal extends BasePage {

    private final SelenideElement TITLE = $x("//h3[text()='Create new project']");
    private final SelenideElement PROJECT_NAME_INPUT = $("#project-name");
    private final SelenideElement PROJECT_CODE_INPUT = $("#project-code");
    private final SelenideElement DESCRIPTION_INPUT = $("#description-area");
    private final SelenideElement CREATE_BTN = $(byText("Create project"));

    @Override
    public BasePage openPage() {
        return null;
    }

    @Override
    public CreateNewProjectModal isPageOpened() {
        TITLE.shouldBe(visible);
        return this;
    }

    public ProjectPage fillCreateNewProjectModal(String name, String code, String description) {
        PROJECT_NAME_INPUT.setValue(name);
        PROJECT_CODE_INPUT.setValue(code);
        DESCRIPTION_INPUT.setValue(description);
        CREATE_BTN.click();
        return new ProjectPage();
    }
}
