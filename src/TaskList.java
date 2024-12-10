import java.util.HashMap;
/**
 * Класс списка с задачами со свойствами <b>taskList</b>, <b>status</b>, <b>taskInDict</b>, <b>statusInDict</b>,
 * <b>nameTaskList</b> и <b>taskID</b>.
 * @autor zhurand
 * @version 1.0
 */
public class TaskList{
    /** Поле словарь всех списков задач */
    private HashMap<String, HashMap> taskList = new HashMap<>();
    /** Поле словарь статусов задач во всех списках */
    private HashMap<String, HashMap> status = new HashMap<>();
    /** Поле задача в словаре */
    private HashMap<Integer, String> taskInDict = new HashMap<>();
    /** Поле статус в словаре */
    private HashMap<Integer, String> statusInDict = new HashMap<>();
    /** Поле имя списка задач */
    private String nameTaskList;
    /** Поле идентификатор задачи */
    private int taskID;
    /** Создание нового списка задач
     * @param nameTaskList имя списка задач
     * */
    public TaskList(String nameTaskList) {
        this.nameTaskList = nameTaskList;
        taskList.put(this.nameTaskList, taskInDict);
    }
    /**
     * Функция получения значения поля {@link TaskList#nameTaskList}
     * @return возвращает название списка задач
     */
    public String getNameTaskList() {
        return nameTaskList;
    }
    /**
     * Процедура определения названия списка задач
     * @param nameTaskList название списка задач
     */
    public void setNameTaskList(String nameTaskList) {
        this.nameTaskList = nameTaskList;
    }
    /**
     * Процедура добавления задачи в словарь со всеми списками задач
     * @param task задача
     */
    public void addTask(Task task) {
        if (taskList.isEmpty() || taskList.get(task.getNameTaskList()) == null) {
            taskID = 1;
            taskInDict.clear();
            statusInDict.clear();
        }
        else {
            taskID = taskList.get(task.getNameTaskList()).size() + 1;
        }
        if (task.getTaskMakeOption().equals("2")) {
            taskList.get(task.getNameTaskList()).put(
                    taskList.get(task.getNameTaskList()).size() + 1, task.getTaskDescription());
            status.get(task.getNameTaskList()).put(
                    taskList.get(task.getNameTaskList()).size(), task.getTaskStatus());
        }
        else {
            taskInDict.put(taskID, task.getTaskDescription());
            taskList.put(nameTaskList, (HashMap) taskInDict.clone());
            statusInDict.put(taskID, task.getTaskStatus());
            status.put(nameTaskList, (HashMap) statusInDict.clone());
        }
    }
    /**
     * Процедура вывода всех списков задач в консоль
     */
    public void printTaskList() {
        for (String key : taskList.keySet()) {
            System.out.print("\n### " + key + " ###\n");
            if (taskList.get(key).isEmpty()) {
                System.out.println("Список пуст");
            }
            int iter = 1;
            for (Object value : taskList.get(key).values()) {
                System.out.println(iter + " " + value + " [" +
                        status.get(key).get(iter) + "]");
                iter += 1;
            }
            System.out.print("----------\n");
        }
    }
    /**
     * Функция определения наличия списка задач в словаре taskList
     * @param nameTaskList имя списка задач
     * @return возвращает true если список задач есть в taskList, false если его нет
     */
    public Boolean existsTaskList(String nameTaskList) {
        boolean exists = false;
        for (String key : taskList.keySet()) {
            if (key.equals(nameTaskList)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    /** Функция получения описания задачи
     * @param nameTaskList имя списка задач
     * @param taskID идентификатор задачи
     * @return возвращает описание задачи */
    public String getTaskDescription(String nameTaskList, int taskID) {
        return (String) taskList.get(nameTaskList).get(taskID);
    }
    /**
     * Процедура редактирования описания задачи
     * @param nameTaskList название списка задач
     * @param taskID идентификатор задачи
     * @param newTaskDescription новое описание задачи
     */
    public void editTaskDescription(String nameTaskList, int taskID, String newTaskDescription) {
        HashMap task = taskList.get(nameTaskList);
        task.put(taskID, newTaskDescription);
    }
    /**
     * Процедура редактирования статуса задачи
     * @param nameTaskList название списка задач
     * @param taskID идентификатор задачи
     * @param newStatus новый статус задачи
     */
    public void editStatusTask(String nameTaskList, int taskID, String newStatus) {
        HashMap task = status.get(nameTaskList);
        task.put(taskID, newStatus);
    }
    /**
     * Процедура удаления списка статусов для списка задач
     * @param nameTaskList название списка задач
     */
    public void deleteStatusList(String nameTaskList) {
        status.remove(nameTaskList);
    }
    /**
     * Процедура удаления списка задач
     * @param nameTaskList название списка задач
     */
    public void deleteTaskList(String nameTaskList) {
        taskList.remove(nameTaskList);
        deleteStatusList(nameTaskList);
    }
    /**
     * Процедура удаления задачи из списка задач
     * @param nameTaskList название списка задач
     * @param taskID идентификатор задачи
     */
    public void deleteTask(String nameTaskList, int taskID) {
        int idTaskForMapTasks = taskID;
        int idTaskForMapStatus = taskID;

        HashMap mapTasks = taskList.get(nameTaskList);
        HashMap mapTasksCopy = (HashMap) mapTasks.clone();
        for (int iter = idTaskForMapTasks + 1; iter <= mapTasks.size(); iter++) {
            mapTasks.put(idTaskForMapTasks, mapTasksCopy.get(iter));
            idTaskForMapTasks += 1;
        }
        mapTasks.remove(mapTasks.size());
        mapTasksCopy.clear();

        HashMap mapStatus = status.get(nameTaskList);
        HashMap mapStatusCopy = (HashMap) mapStatus.clone();
        for (int iter = idTaskForMapStatus + 1; iter <= mapStatus.size(); iter++) {
            mapStatus.put(idTaskForMapStatus, mapStatusCopy.get(iter));
            idTaskForMapStatus += 1;
        }
        mapStatus.remove(mapStatus.size());
        mapStatusCopy.clear();
    }
    /** Функция получения размера списка задач
     * @param nameTaskList имя списка задач
     * @return возвращает размер списка задач */
    public int sizeTaskList(String nameTaskList) {
        int size = 0;
        if (taskList.get(nameTaskList) == null) {
            size = 0;
        }
        else {
            size = taskList.get(nameTaskList).size();
        }
        return size;
    }
    /** Функция получения размера словара со списками задач
     * @return возвращает размер словаря со списками задач */
    public int size() {
        return taskList.size();
    }
}
