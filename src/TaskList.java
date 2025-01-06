import java.util.List;
import java.util.ArrayList;
/**
 * Класс списка с задачами со свойствами <b>title</b>, <b>tasks</b>.
 * @autor zhurand
 * @version 1.0
 */
class TaskList {
    /** Поле название списка задач */
    private String title;
    /** Поле список задач */
    private List<Task> tasks;
    /**
     * Создание нового списка задач
     * @param title название списка задачи
     */
    public TaskList(String title) {
        this.title = title;
        this.tasks = new ArrayList<>();
    }
    /**
     * Функция получения значения поля {@link TaskList#title}
     * @return возвращает название списка задач
     */
    public String getTitle() {
        return title;
    }
    /**
     * Процедура определения названия списка задач {@link TaskList#title}
     * @param title название списка задачи
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Функция получения значения поля {@link TaskList#tasks}
     * @return возвращает список задач
     */
    public List getTasks() {
        return tasks;
    }
    /**
     * Процедура добавления задачи в список задач {@link TaskList#tasks}
     * @param task задача
     */
    public void addTask(Task task) {
        tasks.add(task);
    }
    /**
     * Процедура удаления задачи из списка задач {@link TaskList#tasks}
     * @param number номер задачи
     */
    public void removeTask(int number) {
        tasks.removeIf(task -> task.getNumber() == number);
    }
    /**
     * Процедура редактирования задачи в списке задач {@link TaskList#tasks}
     * @param number номер задачи
     * @param newTitle новое название задачи
     * @param status статус задачи
     */
    public void editTask(int number, String newTitle, boolean status) {
        for (Task task : tasks) {
            if (task.getNumber() == number) {
                task.setStatus(status);
                task.setTitle(newTitle);
                break;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== " + title + " ===\n");
        for (Task task : tasks) {
            sb.append(task.toString()).append("\n");
        }
        return sb.toString();
    }
}
