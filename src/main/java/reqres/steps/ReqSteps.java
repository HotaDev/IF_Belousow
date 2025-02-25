package reqres.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class ReqSteps {

    public ObjectNode editFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ObjectNode objectNode = (ObjectNode) objectMapper.readTree(new File(path));
            objectNode.put("name", "Tomato");
            objectNode.put("job", "Eat maket");
            return objectNode;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
