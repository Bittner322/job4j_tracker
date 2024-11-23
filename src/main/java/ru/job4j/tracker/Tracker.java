package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public boolean replace(int id, Item item) {
        boolean isReplaced = false;
        int indexOfItem = indexOf(id);
        if (indexOfItem != -1) {
            items[indexOfItem] = item;
            isReplaced = true;
        }
        return isReplaced;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] foundItems = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                foundItems[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(foundItems, size);
    }

    public Item[] findByName(String key) {
        Item[] foundItems = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                foundItems[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(foundItems, size);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }
}