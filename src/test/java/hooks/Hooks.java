package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;

public class Hooks {
    @Before("@ifellow")
    public void browserStart() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;
        Selenide.open("https://edujira.ifellow.ru/");

        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @After("@ifellow")
    public void browserEnd() {
        Selenide.closeWebDriver();
    }
}
