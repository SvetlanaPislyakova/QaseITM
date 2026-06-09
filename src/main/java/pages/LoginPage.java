package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    private final SelenideElement EMAIL_INPUT = $("[name=email]");
    private final SelenideElement PASSWORD_INPUT = $("[name=password]");
    private final SelenideElement SIGN_IN_BTN = $(byText("Sign in"));
    private final SelenideElement TITLE = $(byText("Log in to your account"));

    @Override
    public LoginPage openPage() {
        open(baseUrl + "/login");
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        TITLE.shouldBe(visible);
        return this;
    }

    public LoginPage acceptCookies() {
        $("#usercentrics-cmp-ui").getShadowRoot().findElement(By.cssSelector("#accept")).click();
        return this;
    }

    public MainPage login(String email, String password) {
        EMAIL_INPUT.setValue(email);
        PASSWORD_INPUT.setValue(password);
        SIGN_IN_BTN.click();
        sleep(5000);
        return new MainPage();
    }
}
