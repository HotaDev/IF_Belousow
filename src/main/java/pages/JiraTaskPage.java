package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

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
    private String countTask;

    public void filterAllTasks() {
        changeFilter.shouldBe(visible, Duration.ofSeconds(10)).click();
        allTasks.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public void createAndCheck() {
        title.shouldBe(exist, Duration.ofSeconds(10));
        createButton.click();

        typeTask.shouldBe(exist, Duration.ofSeconds(10));
        this.countTask = showTasks.getText();
    }

    public void setValueTask(String type, String topic) {
        typeTask.sendKeys(Keys.CONTROL + "a");
        typeTask.sendKeys(Keys.DELETE);
        typeTask.setValue(type);

        topicTask.setValue(topic);
    }

    public void createTask() {
        createTask.click();
    }

    public void refreshCheck() {
        refresh.click();
        showTasks.shouldNotHave(text(this.countTask), Duration.ofSeconds(10));

        String firstCountTasks = this.countTask.split(" ")[2];
        String enotherString = showTasks.getText();
        String enotherCountTasks = enotherString.split(" ")[2];

        Assertions.assertNotEquals(firstCountTasks, enotherCountTasks, "Задача не добавлена");
    }

    public void checkTasks() {
        filterAllTasks();
        createAndCheck();
        setValueTask("Задача", "123");
        createTask();
        refreshCheck();
    }

}
