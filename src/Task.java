/**
 * Класс задачи со свойствами <b>number</b>, <b>title</b>, <b>status</b>.
 * @autor zhurand
 * @version 1.0
 */
class Task {
    /** Поле номер задачи */
    private int number;
    /** Поле название задачи */
    private String title;
    /** Поле статус задачи */
    private boolean status;
    /**
     * Создание новой задачи
     * @param number номер задачи
     * @param title название задачи
     */
    public Task(int number, String title) {
        this.number = number;
        this.title = title;
        this.status = false;
    }
    /**
     * Функция получения значения поля {@link Task#number}
     * @return возвращает номер задачи
     */
    public int getNumber() {
        return number;
    }
    /**
     * Процедура определения номера задачи {@link Task#number}
     * @param number номер задачи
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     * Функция получения значения поля {@link Task#title}
     * @return возвращает название задачи
     */
    public String getTitle() {
        return title;
    }
    /**
     * Процедура определения названия задачи {@link Task#title}
     * @param title название задачи
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Функция получения значения поля {@link Task#status}
     * @return возвращает статус задачи
     */
    public boolean getStatus() {
        return status;
    }
    /**
     * Процедура определения статуса задачи {@link Task#status}
     * @param status статус задачи
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return number + ". " + title + " [" + (status ? "+" : "-") + "]"; // "+" - выполнено, "-" - не выполнено
    }
}