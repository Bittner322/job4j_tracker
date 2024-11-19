package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.println("Is active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error404 = new Error(true, 404, "Page not found");
        Error error300 = new Error(true, 300, "Multiple choices");
        Error error301 = new Error(true, 301, "Moved permanently");

        error.showInfo();
        error404.showInfo();
        error300.showInfo();
        error301.showInfo();
    }
}
