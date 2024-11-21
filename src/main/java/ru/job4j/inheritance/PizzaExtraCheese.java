package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private final String EXTRA_CHEESE_NAME = "extra cheese";

    public String name() {
        return super.name() + " " + EXTRA_CHEESE_NAME;
    }
}
