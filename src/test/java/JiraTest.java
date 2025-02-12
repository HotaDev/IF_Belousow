import org.junit.jupiter.api.Test;
import pages.*;

public class JiraTest extends WebHooks {

    JiraLoginPage jiraLoginPage = new JiraLoginPage();
    JiraMainPage jiraMainPage = new JiraMainPage();
    JiraTaskPage jiraTaskPage = new JiraTaskPage();
    JiraSearchPage jiraSearchPage = new JiraSearchPage();
    JiraNewTaskPage jiraNewTaskPage = new JiraNewTaskPage();

    @Test
    public void firstTaskTest() {
        jiraLoginPage.login();
    }

    @Test
    public void secondTaskTest() {
        jiraLoginPage.login();
        jiraMainPage.goProjTest();
    }

    @Test
    public void thirdTaskTest() {
        jiraLoginPage.login();
        jiraMainPage.goProjTest();
        jiraTaskPage.checkTasks();
    }

    @Test
    public void fourthTaskTest() {
        jiraLoginPage.login();
        jiraMainPage.goProjTest();
        jiraTaskPage.checkTasks();
        jiraSearchPage.findTask();
    }

    @Test
    public void fifthTaskTest() {
        jiraLoginPage.login();
        jiraMainPage.goProjTest();
        jiraTaskPage.checkTasks();
        jiraSearchPage.findTask();
        jiraMainPage.goProjTest();
        jiraNewTaskPage.createTask();
    }
}
