package reqres.services;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

import static utilities.FileReader.readJsonFile;

public class ReqServices {

    public ObjectNode editFile(String path) {
        try {
            ObjectNode objectNode = (ObjectNode) readJsonFile(path);
            objectNode.put("name", "Tomato");
            objectNode.put("job", "Eat maket");
            return objectNode;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
