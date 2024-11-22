package ru.job4j.pojo;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иванов Иван Иванович");
        student.setGroup("А-100");
        student.setDateOfInsert(LocalDateTime.now());

        System.out.println(student.getFio());
        System.out.println(student.getGroup());
        System.out.println(student.getDateOfInsert());
    }
}
