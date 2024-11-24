package ru.job4j.polymorphism;

public class Bus implements Transport {
    int passengersCount;

    @Override
    public void move() {
        System.out.println("Moving...");
    }

    @Override
    public void passengers(int count) {
        this.passengersCount = count;
    }

    @Override
    public int refuel(int fuel) {
        return 55 * fuel;
    }
}
