package hooks;

import io.cucumber.java.Before;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import utilities.ConfReader;

public class Hooks {

    private static boolean started = false;

    @Before
    public static void setUpAll() {
        if (!started) {
            RestAssured.filters(new AllureRestAssured());
            started = true;
        }
    }

    @Before("@RnM")
    public static void setUpRnM() {
        RestAssured.baseURI = ConfReader.getProperty("rnm.url");
    }

    @Before("@Req")
    public static void setUpReq() {
        RestAssured.baseURI = ConfReader.getProperty("req.url");
    }
}
