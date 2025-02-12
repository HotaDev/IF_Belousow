import org.junit.jupiter.api.Test;
import pages.JiraLoginPage;
import pages.JiraMainPage;
import pages.JiraTaskPage;

public class JiraTest extends WebHooks {

    JiraLoginPage jiraLoginPage = new JiraLoginPage();
    JiraMainPage jiraMainPage = new JiraMainPage();
    JiraTaskPage jiraTaskPage = new JiraTaskPage();

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
}
