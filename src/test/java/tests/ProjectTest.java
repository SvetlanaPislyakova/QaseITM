package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProjectTest extends BaseTest {

    @BeforeEach
    public void login() {
        loginSteps.login(email, password);
    }

    @Test
    @DisplayName("Проверка создания нового проекта")
    public void checkCreateProject() {
        projectSteps.createNewProject("TestName", "TestCode", "TestDescription");

    }

    @Test
    @DisplayName("Проверка удаления проекта")
    public void checkDeleteProject() {
        projectSteps.createNewProject("TestName2", "TestCode2", "TestDescription2")
                .deleteProject("TestName2");
    }
}
