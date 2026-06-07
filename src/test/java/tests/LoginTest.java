package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Авторизация с корректными значениями email и password")
    public void positiveLogin() {
        loginSteps.login(email, password);
    }
}
