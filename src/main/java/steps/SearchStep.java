package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.JiraSearchPage;

public class SearchStep {

    private final JiraSearchPage searchPage = new JiraSearchPage();

    @Когда("^нажать на кнопку 'Посмотреть все задачи и фильтры'")
    public void clickAllTaskStep() {
        searchPage.clickAllTask();
    }

    @И("^ввести в поле поиска '(.*)'")
    public void setValueSearchStep(String title) {
        searchPage.setValueSearch(title);
    }

    @И("^нажать на кнопку 'Поиск'")
    public void clickSearchStep() {
        searchPage.clickSearch();
    }

    @Тогда("^проверить 'статус задачи - Сделать' и 'Исправить в версиях: - Version 2.0' задачи")
    public void checkDataStep() {
        searchPage.checkData();
    }

    @И("^найдена и проверена задача '(.*)'")
    public void findTaskStep(String title) {
        searchPage.findTask(title);
    }
}
