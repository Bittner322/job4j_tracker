package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> predicate) {
        ArrayList<Folder> result = new ArrayList<>();
        predicate = folder -> folder.getName().contains("bug") || folder.getSize() > 100;
        for (Folder folder : list) {
            if (predicate.test(folder)) {
                result.add(folder);
            }
        }
        return result;
    }
}