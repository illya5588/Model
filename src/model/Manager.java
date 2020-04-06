package model;

import java.time.LocalDate;
import java.util.Objects;

public class Manager {
    String surname;
    String name;
    LocalDate DOB;


    public Manager() {
    }

    public Manager(String surname, String name, LocalDate DOB) {
        this.surname = surname;
        this.name = name;
        this.DOB = DOB;
    }



}
