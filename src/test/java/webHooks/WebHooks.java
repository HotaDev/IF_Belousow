package webHooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import configReader.ConfReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

public class WebHooks {
    private static final String baseUrl = ConfReader.getProperty("base.url");

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;

        Selenide.open(baseUrl);

        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void endTest() { Selenide.closeWebDriver(); }
}
