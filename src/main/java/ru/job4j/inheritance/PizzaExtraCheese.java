package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private final String extraCheeseName = "extra cheese";

    public String name() {
        return super.name() + " " + extraCheeseName;
    }
}
