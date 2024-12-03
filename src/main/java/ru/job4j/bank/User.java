package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя банковской системы
 * @author mikhail
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя хранится в переменной типа String
     */
    private String passport;
    /**
     * Имя пользователя хранится в переменной типа String
     */
    private String username;

    /**
     * Конструктор, определяющий дефолтное значение полей
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод описывает получение паспорта пользователя
     * @return возвращает паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод описывает присвоение паспорта пользователю
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод описывает получение имени пользователя
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод описывает присвоение имени пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}