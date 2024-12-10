/**
 * Класс задачи со свойствами <b>nameTaskList</b>, <b>taskDescription</b>, <b>taskMakeOption</b> и <b>taskStatus</b>.
 * @autor zhurand
 * @version 1.0
 */
public class Task {
    /** Поле название списка задач */
    private String nameTaskList;
    /** Поле описание задачи */
    private String taskDescription;
    /** Поле способ создания задачи */
    private String taskMakeOption;
    /** Поле статус задачи */
    private String taskStatus;
    /**
     * Создание новой задачи
     * @param nameTaskList название списка задач
     * @param taskDescription описание задачи
     * @param taskMakeOption способ создания задачи
     */
    public Task(String nameTaskList, String taskDescription, String taskMakeOption) {
        this.nameTaskList = nameTaskList;
        this.taskDescription = taskDescription;
        this.taskMakeOption = taskMakeOption;
        this.taskStatus = "нет";
    }
    /**
     * Функция получения значения поля {@link Task#nameTaskList}
     * @return возвращает название списка задач
     */
    public String getNameTaskList() {
        return nameTaskList;
    }
    /**
     * Процедура определения названия списка задач {@link Task#nameTaskList}
     * @param nameTaskList название списка задач
     */
    public void setNameTaskList(String nameTaskList) {
        this.nameTaskList = nameTaskList;
    }
    /**
     * Функция получения значения поля {@link Task#taskDescription}
     * @return возвращает описание задачи
     */
    public String getTaskDescription() {
        return taskDescription;
    }
    /**
     * Процедура определения описания задачи {@link Task#taskDescription}
     * @param taskDescription описание задачи
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    /**
     * Процедура определения способа создания задачи {@link Task#taskMakeOption}
     * @param taskMakeOption способ создания задачи
     */
    public void setTaskMakeOption(String taskMakeOption) {
        this.taskMakeOption = taskMakeOption;
    }
    /**
     * Функция получения способа создания задачи {@link Task#taskMakeOption}
     * @return возвращает способ создания задачи
     */
    public String getTaskMakeOption() {
        return taskMakeOption;
    }
    /**
     * Функция получения статуса задачи {@link Task#taskStatus}
     * @return возвращает статус задачи
     */
    public String getTaskStatus() {
        return taskStatus;
    }
    /**
     * Процедура определения статуса задачи {@link Task#taskStatus}
     * @param taskStatus статус задачи
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
