/**
 * --СПИСОК ЗАДАЧ--
 * Функционал:
 * --Создание списка задач
 * --Удаление списка задач
 * --Редактирование списка задач
 * --Создание задачи с добавлением в список
 * --Удаление задачи
 * --Редактирование задачи
 * --Вывод в консоль всех списков и задач
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskList tasks = null;
        Task task = null;
        int sizeTaskList = 0;
        System.out.print(
                        "1 - Создать список задач\n" +
                        "2 - Редактировать список задач\n" +
                        "3 - Удалить список задач\n" +
                        "4 - Напечатать список(и) задач\n" +
                        "5 - Выйти из программы\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nВведите команду: ");
            String option = scanner.nextLine();
            if (option.equals("5")) {
                break;
            }
            switch (option) {
                case "1": {
                    System.out.print("\nВведите название для списка задач: ");
                    String nameTaskList = scanner.nextLine();
                    if (tasks == null & !nameTaskList.isEmpty() & !nameTaskList.isBlank()) {
                        tasks = new TaskList(nameTaskList);
                    }
                    else if (nameTaskList.isEmpty()) {
                        System.out.println("\n-> Ошибка! Название списка не может быть пустым");
                        break;
                    }
                    else if (nameTaskList.isBlank()) {
                        System.out.println("\n-> Ошибка! Название списка не может состоять из одних лишь пробелов");
                        break;
                    }
                    else if (tasks.existsTaskList(nameTaskList)) {
                        System.out.println("\n-> Список с таким именем уже создан!");
                        break;
                    }
                    else {
                        tasks.setNameTaskList(nameTaskList);
                    }
                    System.out.println("[чтобы завершить ввод задач введите 0]");
                    while (true) {
                        System.out.print("Введите задачу: ");
                        String taskDescription = scanner.nextLine();
                        if (taskDescription.equals("0")) {
                            break;
                        }
                        if (taskDescription.isBlank()) {
                            System.out.println("\n-> Ошибка! Задача должна иметь описание\n");
                        }
                        else {
                            task = new Task(nameTaskList, taskDescription, option);
                            tasks.addTask(task);
                            sizeTaskList = tasks.sizeTaskList(nameTaskList);
                        }
                    }
                    /*
                    Проверяем размер списка задачи.
                    Если размер списка задачи равен <0>, то это означает, что список не содержит задач,
                    то есть он пустой. Такой список не сохраняем.
                    Удаляем из словаря ключ <nameTaskList>.
                     */
                    if (tasks.sizeTaskList(nameTaskList) == 0) {
                        sizeTaskList = tasks.sizeTaskList(nameTaskList);
                        tasks.deleteTaskList(nameTaskList);
                    }
                    break;
                }
                case "2": {
                    if (tasks == null) {
                        System.out.println("\n-> Нет созданных списков");
                        break;
                    }
                    if (sizeTaskList == 0 & tasks.size() == 0) {
                        System.out.println("\n-> Нет созданных списков");
                        break;
                    }
                    else {
                        System.out.print("Введите имя списка, которое хотите редактировать: ");
                        String nameTaskList = scanner.nextLine();
                        if (!tasks.existsTaskList(nameTaskList)) {
                            System.out.println("\n-> Список задач с таким именем не найден");
                        }
                        else {
                            System.out.print(
                                    "1 - Редактировать описание задачи\n" +
                                    "2 - Изменить статус задачи\n" +
                                    "3 - Добавить задачу\n" +
                                    "4 - Удалить задачу\n");
                            System.out.print("Введите номер опции: ");
                            String optionEditTaskList = scanner.nextLine();
                            switch (optionEditTaskList) {
                                case "1": {
                                    System.out.print("Введите номер задачи: ");
                                    try {
                                        int taskID = Integer.parseInt(scanner.nextLine());
                                        if (tasks.getTaskDescription(nameTaskList, taskID) == null) {
                                            System.out.println("\n-> Ошибка! Не найден номер задачи");
                                            break;
                                        }
                                        System.out.print(
                                                "Вы хотите изменить задачу: " +
                                                        tasks.getTaskDescription(nameTaskList, taskID) + "\n");
                                        System.out.print("Введите новое описание задачи: ");
                                        String newTaskDescription = scanner.nextLine();
                                        tasks.editTaskDescription(nameTaskList, taskID, newTaskDescription);
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("\n-> Ошибка! Номер задачи должен быть числом");
                                    }
                                    finally {
                                        break;
                                    }
                                }
                                case "2": {
                                    System.out.print("Введите номер задачи: ");
                                    try {
                                        int taskID = Integer.parseInt(scanner.nextLine());
                                        if (tasks.getTaskDescription(nameTaskList, taskID) == null) {
                                            System.out.println("\n-> Ошибка! Не найден номер задачи");
                                            break;
                                        }
                                        System.out.print("[да - задача выполнена, нет - задача не выполнена]\nВведите новый статус для задачи: ");
                                        String newStatus = scanner.nextLine();
                                        if (newStatus.equals("да") | newStatus.equals("нет")) {
                                            tasks.editStatusTask(nameTaskList, taskID, newStatus);
                                        }
                                        else {
                                            System.out.println("\n-> Ошибка! Вы ввели недопустимое значение для статуса задачи");
                                        }
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("\n-> Ошибка! Номер задачи должен быть числом");
                                    }
                                    finally {
                                        break;
                                    }
                                }
                                case "3": {
                                    System.out.print("Введите задачу: ");
                                    String taskDescription = scanner.nextLine();
                                    task = new Task(nameTaskList, taskDescription, option);
                                    tasks.addTask(task);
                                    break;
                                }
                                case "4": {
                                    System.out.print("Введите номер задачи, чтобы удалить ее: ");
                                    try {
                                        int taskID = Integer.parseInt(scanner.nextLine());
                                        if (tasks.getTaskDescription(nameTaskList, taskID) == null) {
                                            System.out.println("\n-> Ошибка! Не найден номер задачи");
                                            break;
                                        }
                                        tasks.deleteTask(nameTaskList, taskID);
                                    }
                                    catch (NumberFormatException e) {
                                        System.out.println("\n-> Ошибка! Номер задачи должен быть числом");
                                    }
                                    finally {
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                case "3": {
                    if (tasks == null) {
                        System.out.println("\n-> Нет созданных списков");
                        break;
                    }
                    if (sizeTaskList == 0 & tasks.size() == 0) {
                        System.out.println("\n-> Нет созданных списков");
                        break;
                    }
                    System.out.print("\nВведите название списка, чтобы его удалить: ");
                    String nameTaskList = scanner.nextLine();
                    if (!tasks.existsTaskList(nameTaskList)) {
                        System.out.println("\n-> Список задач с таким именем не найден");
                    }
                    else {
                        System.out.print("Список задач " + "\"" + nameTaskList + "\"" + " будет удален.\n" +
                                "Вы уверены? (1 - подтверждаю/ 0 - отмена)\nПодтвердите свое согласие: ");
                        String answer = scanner.nextLine();
                        if (answer.equals("1")) {
                            tasks.deleteTaskList(nameTaskList);
                            System.out.println("\n-> Список " + "\"" + nameTaskList + "\"" + " был удален.");
                            /*
                            После удаления списка задач проверяем размер словаря со всеми списками,
                            и если список пустой, то инициализируем его как null,
                            иначе после удаления всех списков задач, кейсы <2,3,4> переключателя option
                            не будут корректно отрабатывать.
                             */
                            if (tasks.size() == 0) {
                                tasks = null;
                            }
                        }
                        else if (answer.equals("0")) {
                            break;
                        }
                        else {
                            System.out.println("\n-> Некорректный ввод");
                            break;
                        }
                    }
                    break;
                }
                case "4": {
                    if (tasks != null) {
                        if (sizeTaskList == 0 & tasks.size() == 0) {
                            System.out.println("\n-> Нет созданных списков");
                        }
                        tasks.printTaskList();
                    }
                    else {
                        System.out.println("\n-> Нет созданных списков");
                    }
                    break;
                }
            }
        }
    }
}
