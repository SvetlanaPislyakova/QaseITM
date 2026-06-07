package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import steps.LoginSteps;
import steps.ProjectSteps;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    protected String email = System.getProperty("login", PropertyReader.getProperty("email"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));
    protected LoginSteps loginSteps;
    protected ProjectSteps projectSteps;

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.clickViaJs = true;
        Configuration.headless = false;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        Configuration.browserCapabilities = options;

        loginSteps = new LoginSteps();
        projectSteps = new ProjectSteps();
    }

    @AfterEach
    public void tearDown() {
        WebDriver driver = getWebDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
