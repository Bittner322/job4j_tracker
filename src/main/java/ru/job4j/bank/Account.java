package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, описывающий банковский счет
 * @author mikhail
 * @version 1.0
 */
public class Account {
    /**
     * Реквизит счета хранится в переменной типа String
     */
    private String requisite;
    /**
     * Баланс счета хранится в переменной типа double
     */
    private double balance;

    /**
     * Конструктор, описывающий дефолтное значение полей
     * @param requisite реквизит счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод описывает получение реквизита счета
     * @return реквизит счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод описывает присвоение реквизита счета
     * @param requisite реквизит счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод описывает получение баланса счета
     * @return баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод описывает присвоение баланса счета
     * @param balance баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}