package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqres.api.ReqApi;
import reqres.steps.ReqSteps;

import static org.hamcrest.Matchers.equalTo;
import static reqres.constants.EnvConst.FILE_PATH;
import static reqres.constants.EnvConst.REQ_URL;


public class SecondTest {

    private final ReqApi reqApi = new ReqApi();
    private final ReqSteps reqSteps = new ReqSteps();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = REQ_URL;
    }

    @Test
    @DisplayName("Проверка Post-запроса")
    public void checkPostReq() {
        Response response = reqApi.getResponse(reqSteps.editFile(FILE_PATH));
        response.then()
                .statusCode(201)
                .body("name", equalTo("Tomato"))
                .and()
                .body("job", equalTo("Eat maket"));
    }
}
