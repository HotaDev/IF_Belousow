package configReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfReader {
    public static final Properties prop = new Properties();

    static {
        try (InputStream input = ConfReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
