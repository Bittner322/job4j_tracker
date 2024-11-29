package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sandreyf1972@gmail.com", "Шмырев Михаил Андреевич");
        for (String element : map.values()) {
            System.out.println(element);
        }
    }
}
