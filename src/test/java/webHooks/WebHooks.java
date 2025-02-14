package webHooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

public class WebHooks {
    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;

        Selenide.open("https://edujira.ifellow.ru/");

        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void endTest() { Selenide.closeWebDriver(); }
}
