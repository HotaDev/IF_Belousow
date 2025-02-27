package Tests;

import configReader.ConfReader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rick.steps.RnMSteps;

import java.util.Objects;

public class FirstTest {

    private final RnMSteps steps = new RnMSteps();
    private static final String urlRNM = ConfReader.getProperty("rnm.url");
    private static final String character = ConfReader.getProperty("character");

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = urlRNM;
    }

    @Test
    @DisplayName("Сравнение персонажей")
    public void compareChar() {
        String[] charOne = steps.lastEpisodeByChar(character);
        String[] charTwo = steps.getInfoChar(steps.lastCharByEpisode(charOne[2]));
        Assertions.assertFalse(Objects.equals(charOne[0], charTwo[0])
                && Objects.equals(charOne[1], charTwo[1]));
    }

}
