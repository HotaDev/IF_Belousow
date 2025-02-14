package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class JiraMainPage {

    private final SelenideElement projectButton = $x("//a[text()='Проекты']").as("Кнопка Проекты");
    private final SelenideElement testButton = $x("//a[@id='admin_main_proj_link_lnk']").
            as("Кнопка test");
    private final SelenideElement projectText = $x("//span[text()='Открытые задачи']").
            as("Открытые задачи");

    public void goProjTest() {
        projectButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        testButton.shouldBe(visible, Duration.ofSeconds(10)).click();

        projectText.shouldBe(exist, Duration.ofSeconds(10));
        Assertions.assertTrue(projectText.exists(), "Переход не выполнен");

    }
}
