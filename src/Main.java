import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /** Список хранящий списки с задачами */
    private static List<TaskList> taskLists = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1 - Создать список задач");
            System.out.println("2 - Удалить список задач");
            System.out.println("3 - Редактировать список задач");
            System.out.println("4 - Создать задачу");
            System.out.println("5 - Удалить задачу");
            System.out.println("6 - Редактировать задачу");
            System.out.println("7 - Вывести все списки и задачи");
            System.out.println("0 - Выход");
            System.out.print("Выберите действие: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    createTaskList();
                    break;
                case 2:
                    removeTaskList();
                    break;
                case 3:
                    editTaskList();
                    break;
                case 4:
                    createTask();
                    break;
                case 5:
                    removeTask();
                    break;
                case 6:
                    editTask();
                    break;
                case 7:
                    printTaskLists();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("\nНеверный выбор. Попробуйте снова.\n");
            }
        }
    }
    private static void createTaskList() {
        System.out.print("Введите название списка задач: ");
        String title = scanner.nextLine();
        TaskList taskList = new TaskList(title);
        taskLists.add(taskList);
        System.out.println("\nСписок задач создан.\n");
    }
    private static void removeTaskList() {
        System.out.print("Введите название списка задач для удаления: ");
        String title = scanner.nextLine();
        taskLists.removeIf(taskList -> taskList.getTitle().equals(title));
        System.out.println("\nСписок задач удален.\n");
    }
    private static void editTaskList() {
        System.out.print("Введите название списка задач для редактирования: ");
        String title = scanner.nextLine();
        for (TaskList taskList : taskLists) {
            if (taskList.getTitle().equals(title)) {
                System.out.print("Введите новое название списка задач: ");
                String newTitle = scanner.nextLine();
                taskList.setTitle(newTitle);
                System.out.println("\nСписок задач отредактирован.\n");
                return;
            }
        }
        System.out.println("\nСписок задач не найден.\n");
    }
    private static void createTask() {
        System.out.print("Введите название списка задач, в который хотите добавить задачу: ");
        String listTitle = scanner.nextLine();
        for (TaskList taskList : taskLists) {
            if (taskList.getTitle().equals(listTitle)) {
                System.out.print("Введите название задачи: ");
                String taskTitle = scanner.nextLine();
                int taskNumber = taskList.getTasks().size() + 1;
                Task newTask = new Task(taskNumber, taskTitle);
                taskList.addTask(newTask);
                System.out.println("\nЗадача добавлена в список.\n");
                return;
            }
        }
        System.out.println("\nСписок задач не найден.\n");
    }

    private static void removeTask() {
        System.out.print("Введите название списка задач, из которого хотите удалить задачу: ");
        String listTitle = scanner.nextLine();
        for (TaskList taskList : taskLists) {
            if (taskList.getTitle().equals(listTitle)) {
                System.out.print("Введите номер задачи для удаления: ");
                int taskNumber = Integer.parseInt(scanner.nextLine());
                taskList.removeTask(taskNumber);
                System.out.println("\nЗадача удалена из списка.\n");
                return;
            }
        }
        System.out.println("\nСписок задач не найден.\n");
    }

    private static void editTask() {
        System.out.print("Введите название списка задач, в котором хотите редактировать задачу: ");
        String listTitle = scanner.nextLine();
        for (TaskList taskList : taskLists) {
            if (taskList.getTitle().equals(listTitle)) {
                System.out.print("Введите номер задачи для редактирования: ");
                int taskNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите новое название задачи: ");
                String newTitle = scanner.nextLine();
                System.out.print("Статус выполненной задачи (да/нет): ");
                String status = scanner.nextLine();
                boolean isCompleted = status.equalsIgnoreCase("да");
                taskList.editTask(taskNumber, newTitle, isCompleted);
                System.out.println("\nЗадача отредактирована.\n");
                return;
            }
        }
        System.out.println("\nСписок задач не найден.\n");
    }

    private static void printTaskLists() {
        if (taskLists.isEmpty()) {
            System.out.println("\nНет доступных списков задач.\n");
            return;
        }
        System.out.println();
        for (TaskList taskList : taskLists) {
            System.out.println(taskList);
        }
    }
}
