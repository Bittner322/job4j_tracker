package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private final String EXTRA_CHEESE_EXTRA_TOMATO_NAME = "extra tomato";

    public String name() {
        return super.name() + " " + EXTRA_CHEESE_EXTRA_TOMATO_NAME;
    }
}
