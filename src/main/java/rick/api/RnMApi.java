package rick.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RnMApi {
    public JsonPath getJsonPath(String endpoint) {
        return new JsonPath(RestAssured.get(endpoint)
                .getBody().asString());
    }
}
