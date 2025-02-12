package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class JiraTaskPage {

    private final SelenideElement changeFilter = $x("//button[@aria-label='Переключить фильтр']").
            as("Кнопка переключить фильтр");
    private final SelenideElement myTasks = $x("//a[@data-item-id='myopenissues']").
            as("Мои задачи");
    private final SelenideElement title = $x("//span[text()='Мои открытые задачи']").
            as("Мои задачи");
    private final SelenideElement refresh = $x("//span[text()='Обновить результаты']").
            as("Обновить результаты");
    private final ElementsCollection tasks = $$x("//ol[@class='issue-list']/li").
            as("Коллекция элементов");
    private final SelenideElement createButton = $x("//a[text()='Создать']").
            as("Создать");
    private final SelenideElement typeTask = $x("//input[@id='issuetype-field']").
            as("Тип задачи");
    private final SelenideElement topicTask = $x("//input[@id='summary']").
            as("Тема");
    private final SelenideElement assignee = $x("//button[text()='Назначить меня']").as("Иполнитель");
    private final SelenideElement createTask = $x("//input[@value='Создать']").
            as("Кнопка создать задачу");

    public void checkTasks() {
        changeFilter.shouldBe(Condition.exist, Duration.ofSeconds(5));
        changeFilter.click();
        myTasks.shouldBe(Condition.exist, Duration.ofSeconds(5));
        myTasks.click();
        title.shouldBe(Condition.exist, Duration.ofSeconds(5));
        createButton.click();

        typeTask.shouldBe(Condition.exist, Duration.ofSeconds(5));
        int firstCount = tasks.size();
        System.out.println("Количество элементов: " + firstCount);
        typeTask.setValue("Задача");
        topicTask.setValue("123");
        assignee.click();
        createTask.click();

        refresh.click();
        tasks.shouldHave(size(firstCount + 1), Duration.ofSeconds(5));
        int secondCount = tasks.size();
        System.out.println("Количество элементов: " + secondCount);

        Assertions.assertNotEquals(firstCount, secondCount, "Задача не добавлена");

    }
}
