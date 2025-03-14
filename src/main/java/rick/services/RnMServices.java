package rick.services;

import io.restassured.path.json.JsonPath;
import rick.api.RnMApi;

public class RnMServices {

    private final RnMApi api = new RnMApi();

    public String[] lastEpisodeByChar(String name) {
        JsonPath obj = api.getJsonPath("/character/?name=" + name);
        return new String[]{
                obj.getString("results[0].species"),
                obj.getString("results[0].location.name"),
                getLastElem(obj, "results[0].episode[-1]")
        };
    }

    public String lastCharByEpisode(String episode) {
        return getLastElem(
                api.getJsonPath("/episode/" + episode),
                "characters[-1]"
        );
    }

    public String[] getInfoChar(String character) {
        JsonPath obj = api.getJsonPath("/character/" + character);
        return new String[]{
                obj.getString("species"),
                obj.getString("location.name")
        };
    }

    public String getLastElem(JsonPath obj, String path) {
        String url = obj.getString(path);
        String[] splitUrl = url.split("/");
        return splitUrl[splitUrl.length - 1];
    }


}
