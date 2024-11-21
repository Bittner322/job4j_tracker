package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private final String extraCheeseExtraTomatoName = "extra tomato";

    public String name() {
        return super.name() + " " + extraCheeseExtraTomatoName;
    }
}
