package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public boolean replace(int id, Item item) {
        boolean isReplaced = false;
        int indexOfItem = indexOf(id);
        if (indexOfItem != -1) {
            items.set(indexOfItem, item);
            item.setId(id);
            isReplaced = true;
        }
        return isReplaced;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public Item[] findByName(String key) {
        Item[] foundItems = new Item[items.size()];
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getName().equals(key)) {
                foundItems[count] = items.get(index);
                count++;
            }
        }
        return Arrays.copyOf(foundItems, count);
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }
}