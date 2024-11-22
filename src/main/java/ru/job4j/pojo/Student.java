package ru.job4j.pojo;

import java.time.LocalDateTime;

public class Student {
    private String FIO;
    private String group;
    private LocalDateTime dateOfInsert;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDateTime getDateOfInsert() {
        return dateOfInsert;
    }

    public void setDateOfInsert(LocalDateTime dateOfInsert) {
        this.dateOfInsert = dateOfInsert;
    }
}
