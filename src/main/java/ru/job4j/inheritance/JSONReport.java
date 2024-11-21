package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator()
                + "\t" + "\"name\" : " + String.format("\"%s\"", name) + "," + System.lineSeparator()
                + "\t" + "\"body\" : " + String.format("\"%s\"", body)
                + System.lineSeparator() + "}";
    }
}
