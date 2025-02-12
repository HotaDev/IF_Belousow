import org.junit.jupiter.api.Test;
import pages.JiraLoginPage;

public class JiraTest extends WebHooks {

    JiraLoginPage jiraLoginPage = new JiraLoginPage();

    @Test
    public void firstTaskTest() {
        jiraLoginPage.login();
    }

}
