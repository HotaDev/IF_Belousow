package rick.steps;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import rick.services.RnMServices;

import java.util.Objects;

public class RnMSteps {
    private final RnMServices services = new RnMServices();
    private String[] charOne;
    private String[] charTwo;


    @Когда("^запросить информации о персонаже '(.*)' и выбрать информацию о расе, местонахождении и последним эпизоде")
    @Step("Запросить информацию по персонажу {character}")
    public void findFirstCharInfo(String character) {
        charOne = services.lastEpisodeByChar(character);
    }

    @Затем("^выбрать из последнего эпизода последнего персонажа и выбрать информацию о расе, местонахождении")
    @Step("Затем запросить информацию по другому персонажу")
    public void findSecondCharInfo() {
        charTwo = services.getInfoChar(services.lastCharByEpisode(charOne[2]));
    }

    @Тогда("^сравнить расу и местонахождение персонажей")
    @Step("Сравнить персонажей")
    public void compareChar() {
        Assertions.assertFalse(Objects.equals(charOne[0], charTwo[0])
                && Objects.equals(charOne[1], charTwo[1]));
    }

}
