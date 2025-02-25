package Tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rick.steps.RnMSteps;

import java.util.Objects;

import static rick.constants.EnvConst.CHARACTER;
import static rick.constants.EnvConst.RNM_URL;

public class FirstTest {

    private final RnMSteps steps = new RnMSteps();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = RNM_URL;
    }

    @Test
    @DisplayName("Сравнение персонажей")
    public void compareChar() {
        String[] charOne = steps.lastEpisodeByChar(CHARACTER);
        String[] charTwo = steps.getInfoChar(steps.lastCharByEpisode(charOne[2]));
        Assertions.assertFalse(Objects.equals(charOne[0], charTwo[0])
                && Objects.equals(charOne[1], charTwo[1]));
    }

}
