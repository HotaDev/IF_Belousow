package Tests;

import configReader.ConfReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqres.api.ReqApi;
import reqres.steps.ReqSteps;

import static org.hamcrest.Matchers.equalTo;


public class SecondTest {

    private final ReqApi reqApi = new ReqApi();
    private final ReqSteps reqSteps = new ReqSteps();
    private static final String reqRNM = ConfReader.getProperty("req.url");
    private static final String filePath = ConfReader.getProperty("file.path");

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = reqRNM;
    }

    @Test
    @DisplayName("Проверка Post-запроса")
    public void checkPostReq() {
        Response response = reqApi.getResponse(reqSteps.editFile(filePath));
        response.then()
                .statusCode(201)
                .body("name", equalTo("Tomato"))
                .and()
                .body("job", equalTo("Eat maket"));
    }
}
