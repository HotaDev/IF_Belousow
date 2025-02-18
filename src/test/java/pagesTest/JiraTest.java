package pagesTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import webHooks.WebHooks;

public class JiraTest extends WebHooks {

    JiraLoginPage jiraLoginPage = new JiraLoginPage();
    JiraMainPage jiraMainPage = new JiraMainPage();
    JiraTaskPage jiraTaskPage = new JiraTaskPage();
    JiraSearchPage jiraSearchPage = new JiraSearchPage();
    JiraNewTaskPage jiraNewTaskPage = new JiraNewTaskPage();

    @DisplayName("Вход в Jira")
    @Test
    public void firstTaskTest() {
        jiraLoginPage.authJira("AT1", "Qwerty123");
    }

    @DisplayName("Переход в проект Test")
    @Test
    public void secondTaskTest() {
        jiraLoginPage.authJira("AT1", "Qwerty123");
        jiraMainPage.goProjTest();
    }

    @DisplayName("Проверка кол-ва задач")
    @Test
    public void thirdTaskTest() {
        jiraLoginPage.authJira("AT1", "Qwerty123");
        jiraMainPage.goProjTest();
        jiraTaskPage.checkTasks();
    }

    @DisplayName("Проверка задачи")
    @Test
    public void fourthTaskTest() {
        jiraLoginPage.authJira("AT1", "Qwerty123");
        jiraMainPage.goProjTest();
        jiraTaskPage.checkTasks();
        jiraSearchPage.findTask("TestSeleniumATHomework");
    }

    @DisplayName("Создание нового бага")
    @Test
    public void fifthTaskTest() {
        jiraLoginPage.authJira("AT1", "Qwerty123");
        jiraMainPage.goProjTest();
        jiraTaskPage.checkTasks();
        jiraSearchPage.findTask("TestSeleniumATHomework");
        jiraMainPage.goProjTest();
        jiraNewTaskPage.changeStatusCreateTask();
    }
}
