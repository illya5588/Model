package model;

import java.time.LocalDate;
import java.util.Map;

public class Teacher {
    String surname;
    String name;
    LocalDate DOB;

    public Teacher() {
    }

    public Teacher(String surname, String name, LocalDate DOB) {
        this.surname = surname;
        this.name = name;
        this.DOB = DOB;
    }

    public void setMark(Student student, Subject subject, int mark, Map marks) {

        student.markUpdate(subject, mark, marks);
        student.countAvarageMark(marks);
    }
}
