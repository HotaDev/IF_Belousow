package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class JiraLoginPage {

    private final SelenideElement inputLogin = $x("//input[@id='login-form-username']").as("Ввод Логина");
    private final SelenideElement inputPassword = $x("//input[@id='login-form-password']").as("Ввод Пароля");
    private final SelenideElement inputButton = $x("//input[@id='login']").as("Кнопка войти");
    private final SelenideElement projectButton = $x("//a[text()='Проекты']").as("Кнопка Проекты");

    public void authJira(String login, String pass) {
        this.login(login, pass);
        inputButton.click();

        projectButton.shouldBe(exist, Duration.ofSeconds(10));
        Assertions.assertTrue(projectButton.exists(), "Вход не выполнен");

    }
    public void login(String login, String pass) {
        inputLogin.shouldBe(visible, Duration.ofSeconds(10)).setValue(login);
        inputPassword.setValue(pass);
    }
}
