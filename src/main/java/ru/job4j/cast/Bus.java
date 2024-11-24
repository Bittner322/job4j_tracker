package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ездит по дорогам общего пользования");
    }

    @Override
    public void brake() {
        System.out.println("Обычные тормоза");
    }
}
