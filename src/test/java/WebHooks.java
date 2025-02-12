import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.PageLoadStrategy;

public class WebHooks {
    @BeforeAll
    public static void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 15000;

        Selenide.open("https://edujira.ifellow.ru/");

        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterAll
    public static void endTest() { Selenide.closeWebDriver(); }
}
