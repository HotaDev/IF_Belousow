package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.JiraTaskPage;

public class CheckTaskStep {
    private final JiraTaskPage taskPage = new JiraTaskPage();

    @Когда("^переключить фильтр на 'Все задачи'")
    public void filterAllTasksStep() {
        taskPage.filterAllTasks();
    }
    @И("^нажать на кнопку 'Создать', записав при этом количество всех задач")
    public void createAndCheckStep() {
        taskPage.createAndCheck();
    }
    @И("^ввести для задачи Тип: '(.*)' и Тема: '(.*)'")
    public void setValueTaskStep(String type, String topic) {
        taskPage.setValueTask(type, topic);
    }
    @И("^нажать на кнопку 'Создать' в форме 'Создание задачи'")
    public void createTaskStep() {
        taskPage.createTask();
    }
    @Тогда("^при обновлении списка задач увеличится количество всех задач")
    public void refreshCheckStep() {
        taskPage.refreshCheck();
    }
    @И("^проверено общее количество задач")
    public void checkTasks() {
        taskPage.checkTasks();
    }
}
