package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.JiraLoginPage;

public class LoginStep {

    private final JiraLoginPage logPage = new JiraLoginPage();

    @Когда("^ввести '(.*)' и '(.*)' данные пользователя на старнице Jira")
    public void setAuthDataStep(String log, String pas) {
        logPage.setLoginData(log, pas);
    }

    @И("^нажать на кнопку 'Войти'")
    public void clickButtonStep() {
        logPage.clickLogin();
    }

    @Тогда("^осуществляется переход на главную страницу Jira")
    public void authCheckStep() {
        logPage.checkAuth();
    }

    @Дано ("^произведен вход в Jira под данными '(.*)' и '(.*)'")
    public void authJiraStep(String log, String pas) {
        logPage.authJira(log, pas);
    }
}
