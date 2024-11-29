package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("asd@mail.com", "Иванов Иван Иванович");
        map.put("fgh@mail.com", "Петров Петр Петрович");
        map.put("jkl@mail.com", "Матвеев Матвей Матвеевич");
        map.put("asd@mail.com", "Егоров Егор Егорович");
        for (String element : map.values()) {
            System.out.println(element);
        }
    }
}
