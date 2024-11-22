package ru.job4j.pojo;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFIO("Иванов Иван Иванович");
        student.setGroup("А-100");
        student.setDateOfInsert(LocalDateTime.now());

        System.out.println(student.getFIO());
        System.out.println(student.getGroup());
        System.out.println(student.getDateOfInsert());
    }
}
