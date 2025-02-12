import org.junit.jupiter.api.Test;
import pages.JiraLoginPage;
import pages.JiraMainPage;

public class JiraTest extends WebHooks {

    JiraLoginPage jiraLoginPage = new JiraLoginPage();
    JiraMainPage jiraMainPage = new JiraMainPage();

    @Test
    public void firstTaskTest() {
        jiraLoginPage.login();
    }

    @Test
    public void secondTaskTest() {
        jiraLoginPage.login();
        jiraMainPage.goProjTest();
    }
}
