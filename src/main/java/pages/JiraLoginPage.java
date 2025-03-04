package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class JiraLoginPage {

    private final SelenideElement inputLogin = $x("//input[@id='login-form-username']").as("Ввод Логина");
    private final SelenideElement inputPassword = $x("//input[@id='login-form-password']").as("Ввод Пароля");
    private final SelenideElement inputButton = $x("//input[@id='login']").as("Кнопка войти");
    private final SelenideElement projectButton = $x("//a[text()='Проекты']").as("Кнопка Проекты");

    @Step("Ввод данных пользователя и авторизация")
    public void authJira(String login, String pass) {
        setLoginData(login, pass);
        clickLogin();
        checkAuth();
    }

    @Step("Ввод данных пользователя")
    public void setLoginData(String login, String pass) {
        inputLogin.shouldBe(visible, Duration.ofSeconds(10)).setValue(login);
        inputPassword.setValue(pass);
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickLogin() {
        inputButton.click();
    }

    @Step("Происходит авторизация пользователя")
    public void checkAuth() {
        projectButton.shouldBe(exist, Duration.ofSeconds(10));
        Assertions.assertTrue(projectButton.exists(), "Вход не выполнен");
    }
}
