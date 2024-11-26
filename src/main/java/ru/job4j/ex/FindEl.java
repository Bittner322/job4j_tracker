package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                result = index;
                break;
            }
        }
        if (result != -1) {
            return result;
        } else {
            throw new ElementNotFoundException("No such element found: " + key);
        }
    }

    public static void main(String[] args) {
        String[] value = new String[] {"a", "b", "c"};
        try {
            int index = indexOf(value, "d");
            System.out.println(index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}