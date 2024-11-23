package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book cleanCode = new Book();
        book1.setName("Book1");
        book2.setName("Book2");
        book3.setName("Book3");

        cleanCode.setName("Clean code");
        Book[] books = new Book[] {book1, book2, book3, cleanCode};
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println(books[index].getName());
            }
        }
    }
}
