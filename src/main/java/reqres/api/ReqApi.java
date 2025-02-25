package reqres.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReqApi {
    public Response getResponse(ObjectNode node) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(node)
                .post("/api/users");
    }
}
