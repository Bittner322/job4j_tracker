package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String result = "";
        while (count > 1) {
            queue.poll();
            count--;
        }
        result = queue.poll().name();
        return result;
    }

    public String getFirstUpsetCustomer() {
        String result = "";
        while (count > 0) {
            queue.poll();
            count--;
        }
        result = queue.poll().name();
        return result;
    }
}