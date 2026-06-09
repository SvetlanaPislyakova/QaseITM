package steps;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.ProjectPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ProjectSteps {

    private final MainPage mainPage = new MainPage();
    private final ProjectPage projectPage = new ProjectPage();

    @Step("Создание нового проекта с названием '{projectName}'")
    public ProjectSteps createNewProject(String projectName, String projectCode, String description) {
        mainPage.openPage()
                .isPageOpened()
                .createProjectBtnClick()
                .fillCreateNewProjectModal(projectName, projectCode, description)
                .isPageOpened();
        assertTrue(projectPage.getTitle().equalsIgnoreCase(projectCode + " repository"));
        return this;
    }

    @Step("Удаление проекта с названием '{projectName}'")
    public ProjectSteps deleteProject(String projectName) {
        mainPage.openPage()
                .isPageOpened()
                .deleteProject(projectName)
                .checkDeletingProject(projectName);
        return this;
    }
}
