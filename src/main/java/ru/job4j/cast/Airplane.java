package ru.job4j.cast;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Летает");
    }

    @Override
    public void brake() {
        System.out.println("Тормоза только у шасси");
    }
}
