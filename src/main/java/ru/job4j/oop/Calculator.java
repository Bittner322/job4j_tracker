package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int sumOfAllOperations(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(10));
        System.out.println(Calculator.minus(10));
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(10));
        System.out.println(calculator.multiply(10));
        System.out.println(calculator.sumOfAllOperations(10));
    }
}
