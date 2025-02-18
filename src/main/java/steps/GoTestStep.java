package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.JiraMainPage;

public class GoTestStep {
    private final JiraMainPage mainPage = new JiraMainPage();

    @Когда("^при открытии контекстного меню 'Проекты' нажать 'Test'")
    public void clickProjTestStep() { mainPage.clickProjTest(); }
    @Тогда("^осуществляется переход на страницу проекта 'Test'")
    public void checkTitleStep() { mainPage.checkTitleTest(); }
    @И("^произведен переход на проект 'Test'")
    public void goProjStep() { mainPage.goProjTest(); }
}
