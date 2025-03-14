package reqres.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import reqres.api.ReqApi;
import reqres.services.ReqServices;

import static org.hamcrest.Matchers.equalTo;

public class ReqSteps {
    private final ReqServices reqSteps = new ReqServices();
    private final ReqApi reqApi = new ReqApi();
    private Response response;

    @Step("Запрос из файла ")
    @Когда("^создать запрос из файла '(.*)' и поменять в нем значения")
    public void filterAllTasksStep(String name) {
        response = reqApi.getResponse(reqSteps.editFile(name));
    }

    @Step("Проверка ответа")
    @Тогда("^проверить код ответа '(.*)' и информацию")
    public void refreshCheckStep(int code) {
        response.then()
                .statusCode(code)
                .body("name", equalTo("Tomato"))
                .and()
                .body("job", equalTo("Eat maket"));
    }
}
