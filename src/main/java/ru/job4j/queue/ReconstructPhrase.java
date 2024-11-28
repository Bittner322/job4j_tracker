package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder res = new StringBuilder();
        int evenElementsSize = evenElements.size();
        for (int index = 0; index < evenElementsSize; index++) {
            if (index % 2 == 0) {
                res.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return res.toString();
    }

    private String getDescendingElements() {
        StringBuilder res = new StringBuilder();
        int descendingElementsSize = descendingElements.size();
        for (int index = 0; index < descendingElementsSize; index++) {
            res.append(descendingElements.pollLast());
        }
        return res.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}