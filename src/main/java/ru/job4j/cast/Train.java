package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ездит по рельсам");
    }

    @Override
    public void brake() {
        System.out.println("Аварийный тормоз и обычный");
    }
}
