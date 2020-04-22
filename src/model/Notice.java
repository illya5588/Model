package model;


import service.StudentService;

import java.util.Set;

public class Notice {
    private Student student;

    public Notice(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Student  " + this.student + '\n' + this.student;


    }


}
