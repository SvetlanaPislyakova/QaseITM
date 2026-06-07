package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Step("Логин с email '{email}' и password '{password}'")
    public LoginSteps login(String email, String password) {
        loginPage.openPage()
                .isPageOpened()
                .acceptCookies()
                .login(email, password)
                .isPageOpened();
        return this;
    }
}
