package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class JiraTaskPage {

    private final SelenideElement changeFilter = $x("//button[@aria-label='Переключить фильтр']").
            as("Кнопка переключить фильтр");
    private final SelenideElement allTasks = $x("//a[@data-item-id='allissues']").
            as("Все задачи");
    private final SelenideElement title = $x("//span[text()='Все задачи']").
            as("Все задачи");
    private final SelenideElement refresh = $x("//span[text()='Обновить результаты']").
            as("Обновить результаты");
    private final SelenideElement showTasks = $x("//div[@class='showing']").
            as("Все элементы");
    private final SelenideElement createButton = $x("//a[text()='Создать']").
            as("Создать");
    private final SelenideElement typeTask = $x("//input[@id='issuetype-field']").
            as("Тип задачи");
    private final SelenideElement topicTask = $x("//input[@id='summary']").
            as("Тема");
    private final SelenideElement createTask = $x("//input[@value='Создать']").
            as("Кнопка создать задачу");

    public void checkTasks() {
        changeFilter.shouldBe(visible, Duration.ofSeconds(10)).click();
        allTasks.shouldBe(visible, Duration.ofSeconds(10)).click();
        title.shouldBe(exist, Duration.ofSeconds(10));
        createButton.click();

        typeTask.shouldBe(exist, Duration.ofSeconds(10));
        String firstString = showTasks.getText();
        String firstCount = firstString.split(" ")[2];
        typeTask.setValue("Задача");
        topicTask.setValue("123");
        createTask.click();

        refresh.click();
        showTasks.shouldNotHave(text(firstString), Duration.ofSeconds(10));
        String secondString = showTasks.getText();
        String secondCount = secondString.split(" ")[2];

        Assertions.assertNotEquals(firstCount, secondCount, "Задача не добавлена");
    }
}
