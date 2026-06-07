package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    private final SelenideElement TITLE = $x("//h1[text()='Projects']");
    private final SelenideElement CREATE_PROJECT_BTN = $(byText("Create new project"));
    private final String ACTION_MENU_BTN =
            "//*[text()='%s']/ancestor::tr//button[@aria-label='Open action menu']";
    private final SelenideElement REMOVE_BTN = $("[data-testid='remove']");
    private final SelenideElement DELETE_PROJECT_BTN = $x("//span[text()='Delete project']");

    @Override
    public MainPage openPage() {
        open(baseUrl + "/projects");
        return this;
    }

    @Override
    public MainPage isPageOpened() {
        TITLE.shouldBe(visible);
        return this;
    }

    public CreateNewProjectModal createProjectBtnClick() {
        CREATE_PROJECT_BTN.click();
        return new CreateNewProjectModal();
    }

    public MainPage deleteProject(String projectName) {
        $x(String.format(ACTION_MENU_BTN, projectName)).click();
        REMOVE_BTN.click();
        DELETE_PROJECT_BTN.click();
        return this;
    }

    public MainPage checkDeletingProject(String projectName) {
        $(byText(projectName)).shouldNot(exist);
        return this;
    }
}
