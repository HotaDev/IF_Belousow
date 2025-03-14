package webHooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import configReader.ConfReader;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

public class WebHooks {

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;
        Selenide.open(ConfReader.getProperty("base.url"));
        WebDriverRunner.getWebDriver().manage().window().maximize();

        SelenideLogger.addListener("AllureListener", new AllureSelenide()
                .screenshots(Boolean.parseBoolean(ConfReader.getProperty("save.screen")))
                .savePageSource(Boolean.parseBoolean(ConfReader.getProperty("save.page.source"))));

    }

    @AfterEach
    public void endTest() { Selenide.closeWebDriver(); }
}
