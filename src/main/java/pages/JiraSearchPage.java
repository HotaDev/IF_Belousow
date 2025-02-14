package pages;

import com.codeborne.selenide.SelenideElement;
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

    public void findTask(String task) {

        allFilter.shouldBe(visible, Duration.ofSeconds(10)).click();
        searchInput.shouldBe(visible, Duration.ofSeconds(10)).setValue(task);
        buttonSearch.click();
        String stat = status.getText();
        String fix = fixVersion.getText();

        Assertions.assertEquals("СДЕЛАТЬ", stat, "Задача не правильная");
        Assertions.assertEquals("Version 2.0", fix, "Задача не правильная");
    }
}
