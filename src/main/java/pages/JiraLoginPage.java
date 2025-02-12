package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class JiraLoginPage {

    private final SelenideElement inputLogin = $x("//input[@id='login-form-username']").as("Ввод Логина");
    private final SelenideElement inputPassword = $x("//input[@id='login-form-password']").as("Ввод Пароля");
    private final SelenideElement inputButton = $x("//input[@id='login']").as("Кнопка войти");
    private final SelenideElement projectButton = $x("//a[text()='Проекты']").as("Кнопка Проекты");

    public void login() {
        inputLogin.shouldBe(Condition.visible, Duration.ofSeconds(5));
        inputLogin.setValue("AT1");
        inputPassword.setValue("Qwerty123");

        inputButton.click();

        projectButton.shouldBe(Condition.exist, Duration.ofSeconds(5));
        Assertions.assertTrue(projectButton.exists(), "Вход не выполнен");

    }
}
