package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class JiraNewTaskPage {

    private final SelenideElement changeFilter = $x("//button[@aria-label='Переключить фильтр']").
            as("Кнопка переключить фильтр");
    private final SelenideElement allTasks = $x("//a[@data-item-id='allissues']").
            as("Все задачи");
    private final SelenideElement title = $x("//span[text()='Все задачи']").
            as("Все задачи");
    private final SelenideElement createButton = $x("//a[@id='create_link']").
            as("Кнопка создать");
    private final SelenideElement typeTask = $x("//input[@id='issuetype-field']").
            as("Тип задачи");
    private final SelenideElement topicTask = $x("//input[@id='summary']").
            as("Тема");
    private final SelenideElement version = $x("//option[@value='10001']").
            as("Версия");
    private final SelenideElement iframe = $x("//iframe").
            as("Фрейм");
    private final SelenideElement iframeElem = $x("//body").
            as("Элемент фрейма");
    private final ElementsCollection visual = $$x("//button[text()='Визуальный']").
            as("Визуальный");
    private final SelenideElement createTask = $x("//input[@value='Создать']").
            as("Кнопка создать задачу");
    private final SelenideElement inWork = $x("//a[@id='action_id_21']").
            as("В работе");
    private final SelenideElement bisProc = $x("//span[text()='Бизнес-процесс']").
            as("Бизнес-процесс");
    private final SelenideElement done = $x("//span[text()='Исполнено']").
            as("Исполнено");
    private final SelenideElement doneButton = $x("//input[@value='Исполнено']").
            as("Кнопка Исполнено");
    private final SelenideElement comp = $x("//span[text()='Выполнено']").
            as("Выполнено");
    private final SelenideElement status = $x("//span[@id='status-val']/span").
            as("Статус");

    public void createTask() {

        changeFilter.shouldBe(visible, Duration.ofSeconds(10)).click();
        allTasks.shouldBe(visible, Duration.ofSeconds(10)).click();
        title.shouldBe(exist, Duration.ofSeconds(10));
        createButton.click();

        typeTask.shouldBe(visible, Duration.ofSeconds(10));
        typeTask.setValue("Ошибка");
        topicTask.setValue("123");

        visual.get(0).click();

        iframe.shouldBe(visible, Duration.ofSeconds(10));
        Selenide.switchTo().frame(iframe);
        iframeElem.shouldBe(visible, Duration.ofSeconds(10)).setValue("Test");
        Selenide.switchTo().defaultContent();

        visual.get(1).click();
        version.click();
        createTask.click();

    }
    public void changeStatusTask() {

        typeTask.shouldBe(exist, Duration.ofSeconds(10));
        inWork.click();

        done.shouldBe(exist, Duration.ofSeconds(10));
        bisProc.click();

        done.shouldBe(enabled, Duration.ofSeconds(10)).click();

        doneButton.shouldBe(enabled, Duration.ofSeconds(10)).click();

        done.shouldNotBe(exist, Duration.ofSeconds(10));
        comp.shouldBe(exist, Duration.ofSeconds(10));
        bisProc.click();

        comp.shouldBe(enabled, Duration.ofSeconds(10)).click();
    }
    public void changeStatusCreateTask() {

        this.createTask();
        this.changeStatusTask();

        bisProc.shouldNotBe(exist, Duration.ofSeconds(10));
        Assertions.assertEquals("ГОТОВО", status.getText(), "Задача не выполнена");
    }
}
