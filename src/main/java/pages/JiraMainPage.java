package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class JiraMainPage {

    private final SelenideElement projectButton = $x("//a[text()='Проекты']").as("Кнопка Проекты");
    private final SelenideElement testButton = $x("//a[@id='admin_main_proj_link_lnk']").
            as("Кнопка test");
    private final SelenideElement projectText = $x("//span[text()='Открытые задачи']").
            as("Открытые задачи");

    @Step("Переход в проект 'Test'")
    public void goProjTest() {
        clickProjTest();
        checkTitleTest();
    }

    @Step("Нажать на кнопку 'Test'")
    public void clickProjTest() {
        projectButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        testButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Происходит переход в проект 'Test'")
    public void checkTitleTest() {
        projectText.shouldBe(visible, Duration.ofSeconds(10));
        Assertions.assertTrue(projectText.exists(), "Переход не выполнен");
    }
}
