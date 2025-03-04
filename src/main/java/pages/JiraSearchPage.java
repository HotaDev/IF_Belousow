package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class JiraSearchPage {

    private final SelenideElement allFilter = $x("//a[text()='Посмотреть все задачи и фильтры']").
            as("Кнопка посмотреть все фильтры");
    private final SelenideElement searchInput = $x("//input[@id='searcher-query']").
            as("Поиск задачи");
    private final SelenideElement buttonSearch = $x("//button[@original-title='Поиск задач']").
            as("Поиск");
    private final SelenideElement status = $x("//span[@id='status-val']/span").
            as("Статус");
    private final SelenideElement fixVersion = $x("//span[@class='shorten']/a").
            as("Исправить");

    @Step("Нажать на кнопку 'Посмотреть все задачи и фильтры'")
    public void clickAllTask() {
        allFilter.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("ввести в поле поиска {task}")
    public void setValueSearch(String task) {
        searchInput.shouldBe(visible, Duration.ofSeconds(10)).setValue(task);
    }

    @Step("Нажать на кнопку 'Поиск'")
    public void clickSearch() {
        buttonSearch.click();
    }

    @Step("Проверить статусы задачи")
    public void checkData() {
        Assertions.assertEquals("СДЕЛАТЬ", status.getText(), "Задача не правильная");
        Assertions.assertEquals("Version 2.0", fixVersion.getText(), "Задача не правильная");
    }

    @Step("Поиск задачи {task}")
    public void findTask(String task) {
        clickAllTask();
        setValueSearch(task);
        clickSearch();
        checkData();
    }
}
