package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import pages.JiraNewTaskPage;

public class NewTaskStep {
    private final JiraNewTaskPage newTaskPage = new JiraNewTaskPage();

    @И("^нажать на кнопку 'Создать'")
    public void clickCreateStep() {
        newTaskPage.clickCreate();
    }

    @И("^ввести данные о задаче Тип: '(.*)', Тема: '(.*)', Описание: '(.*)'")
    public void setValueTaskStep(String type, String topic, String desc) {
        newTaskPage.setValueTask(type, topic, desc);
    }

    @И("^нажать на кнопку 'В работе'")
    public void inWorkStep() {
        newTaskPage.inWorkStat();
    }

    @И("^открыв 'Бизнес-процесс' нажать на кнопку 'Исполнено'")
    public void doneStatStep() {
        newTaskPage.doneStat();
    }

    @И("^подтвердить дествие нажав на кнопку 'Исполнено'")
    public void acceptDoneStep() {
        newTaskPage.acceptDoneStat();
    }

    @И("^открыв 'Бизнес-процесс' нажать на кнопку 'Выполнено'")
    public void compStatStep() {
        newTaskPage.compStat();
    }

    @Тогда("^проверить 'статус задачи - Готово'")
    public void checkCompStatStep() {
        newTaskPage.checkCompStat();
    }

}
