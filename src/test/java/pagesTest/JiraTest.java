package pagesTest;

import configReader.ConfReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import webHooks.WebHooks;

public class JiraTest extends WebHooks {

    private static final String login = ConfReader.getProperty("login");
    private static final String password = ConfReader.getProperty("pass");
    private static final String fTask = ConfReader.getProperty("find.task");
    private final JiraLoginPage jiraLoginPage = new JiraLoginPage();
    private final JiraMainPage jiraMainPage = new JiraMainPage();
    private final JiraTaskPage jiraTaskPage = new JiraTaskPage();
    private final JiraSearchPage jiraSearchPage = new JiraSearchPage();
    private final JiraNewTaskPage jiraNewTaskPage = new JiraNewTaskPage();

    @Test
    @DisplayName("Вход в Jira")
    public void firstTaskTest() {
        jiraLoginPage.authJira(login, password);
    }

    @Test
    @DisplayName("Переход на проект Тест")
    public void secondTaskTest() {
        jiraLoginPage.authJira(login, password);
        jiraMainPage.goProjTest();
    }

    @Test
    @DisplayName("Проверка кол-ва задач")
    public void thirdTaskTest() {
        jiraLoginPage.authJira(login, password);
        jiraMainPage.goProjTest();
        jiraTaskPage.checkTasks();
    }


    @Test
    @DisplayName("Проверка задачи")
    public void fourthTaskTest() {
        jiraLoginPage.authJira(login, password);
        jiraMainPage.goProjTest();
        jiraTaskPage.checkTasks();
        jiraSearchPage.findTask(fTask);
    }


    @Test
    @DisplayName("Создание нового бага")
    public void fifthTaskTest() {
        jiraLoginPage.authJira(login, password);
        jiraMainPage.goProjTest();
        jiraTaskPage.checkTasks();
        jiraSearchPage.findTask(fTask);
        jiraMainPage.goProjTest();
        jiraNewTaskPage.changeStatusCreateTask();
    }
}
