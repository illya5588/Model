package model;

import exceptions.DateException;
import exceptions.NameException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Student extends User implements Comparable<Student> {


    UUID studentID;
    private float averageMark;
    protected Map<Subject, Integer> marks;
    private static final int MIN_STUDENT_AGE = 15;

    {
        studentID = genID();
    }


    public Student(String surname, String name, LocalDate date) {
        super(date);
        try {

            this.setSurname(surname);
        } catch (NameException e) {
            this.surname = "X";

        }
        try {
            this.setName(name);

        } catch (NameException e) {

            this.name = "X";
        }

        if (Period.between(date, LocalDate.now()).getYears() > MIN_STUDENT_AGE) {
            this.DOB = date;
        } else {
            throw new DateException("Student is too young! Student age should to be greater than " + MIN_STUDENT_AGE + " !");
        }

    }


// Equals and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return
                surname.equals(student.surname) &&
                        name.equals(student.name) &&
                        DOB.equals(student.DOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, DOB);
    }

    public UUID genID() {
        return UUID.randomUUID();


    }


    //Getters and Setters

    public Map<Subject, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<Subject, Integer> marks) {
        this.marks = marks;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return super.toString().concat("\n average mark= " + String.valueOf(averageMark).concat("\n\n"));

    }

    public String getName() {
        return name;
    }

    public UUID getStudentID() {
        return studentID;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }


    @Override
    public int compareTo(Student o) {
        if (this.equals(o)) {
            return 0;
        }
        if (this.averageMark >= o.getAverageMark()) {
            return 1;
        }
        return -1;


    }
}
