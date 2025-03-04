package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class JiraNewTaskPage extends JiraTaskPage {

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
    private final SelenideElement refresh = $x("//span[text()='Обновить результаты']").
            as("Обновить результаты");
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

    @Step("Нажать на кнопку 'Создать'")
    public void clickCreate() {
        title.shouldBe(exist, Duration.ofSeconds(10));
        createButton.click();
    }

    @Step("ввести данные о задаче Тип: {type}, Тема: {topic}, Описание: {desc}")
    public void setValueTask(String type, String topic, String desc) {
        typeTask.shouldBe(visible, Duration.ofSeconds(10));
        typeTask.sendKeys(Keys.CONTROL + "a");
        typeTask.sendKeys(Keys.DELETE);
        typeTask.setValue(type);
        topicTask.setValue(topic);
        visual.get(0).click();

        iframe.shouldBe(visible, Duration.ofSeconds(10));
        Selenide.switchTo().frame(iframe);
        iframeElem.shouldBe(visible, Duration.ofSeconds(10)).setValue(desc);
        Selenide.switchTo().defaultContent();

        visual.get(1).click();
        version.click();
    }

    @Step("Нажать на кнопку 'В работе'")
    public void inWorkStat() {
        refresh.shouldBe(visible, Duration.ofSeconds(10)).click();
        inWork.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Открыть 'Бизнес-процесс' и нажать на кнопку 'Исполнено'")
    public void doneStat() {
        done.shouldBe(exist, Duration.ofSeconds(10));
        bisProc.click();
        done.shouldBe(enabled, Duration.ofSeconds(10)).click();
    }

    @Step("Подтвердить дествие нажав на кнопку 'Исполнено'")
    public void acceptDoneStat() {
        doneButton.shouldBe(enabled, Duration.ofSeconds(10)).click();
    }

    @Step("Открыть 'Бизнес-процесс' и нажать на кнопку 'Выполнено'")
    public void compStat() {
        done.shouldNotBe(exist, Duration.ofSeconds(10));
        comp.shouldBe(exist, Duration.ofSeconds(10));
        bisProc.click();

        comp.shouldBe(enabled, Duration.ofSeconds(10)).click();
    }

    @Step("Проверить 'статус задачи - Готово'")
    public void checkCompStat() {
        bisProc.shouldNotBe(exist, Duration.ofSeconds(10));
        Assertions.assertEquals("ГОТОВО", status.getText(), "Задача не выполнена");
    }

    @Step("Создание новой ошибки и проведение ее по статусам")
    public void changeStatusCreateTask() {
        filterAllTasks();
        clickCreate();
        setValueTask("Ошибка", "123", "Test");
        createTask();
        inWorkStat();
        doneStat();
        acceptDoneStat();
        compStat();
        checkCompStat();
    }
}
