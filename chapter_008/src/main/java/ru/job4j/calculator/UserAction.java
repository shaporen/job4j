package ru.job4j.calculator;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 13.07.2019
 */
public interface UserAction {

    /**
     * Метод возвращает ключ опции.
     * @return ключ.
     */
    String key();

    /**
     * Основной метод.
     * @param input объект типа Input.
     * @param calc объект типа Tracker.
     */
    void execute(Input input, Calculator calc);

    /**
     * Метод возвращает информацию о данном пункте меню.
     * @return Строка меню.
     */
    String info();
}
