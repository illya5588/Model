package service;

import model.Student;
import model.Subject;
import java.time.LocalDate;
import java.time.Period;


public class StudentService {
    protected Student student;


    public StudentService(Student student) {
        this.student = student;
    }


    //Getters and Setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    //Methods

    public StringBuilder subjectWithtMarkTransformation() {
        StringBuilder sb = new StringBuilder();
        for (Subject key : this.student.getMarks().keySet()) {
            int value = this.student.getMarks().get(key);

            sb.append("\t subject= ").append(key).append("   ").append("mark= ").append(value).append("  ").append(markTransformation(value)).append(" ;  \n  ");
        }
        return sb;
    }



    public char markTransformation(int mark) {
        if (mark > 100 || mark < 0) {
            throw new IllegalArgumentException("Invalid value of mark!");
        }

        if (mark >= 90) {
            return 'A';
        }
        if (mark >= 80) {
            return 'B';
        }
        if (mark >= 70) {
            return 'C';
        }
        if (mark >= 60) {
            return 'D';
        }
        if (mark>=50) {
            return 'F';
        }
        return 'U';

    }



    public int age() {
        LocalDate today = LocalDate.now();
        Period result = Period.between(student.getDOB(), today);
        return result.getYears();
    }



    public void markUpdate(Subject subject, int mark) {

        this.student.getMarks().put(subject, mark);
        this.student.setAverageMark(countAverageMark());

    }


    public float countAverageMark() {
        float sum = 0;
        for (Integer i : this.student.getMarks().values()) {
            sum += i;
        }
        return sum / this.student.getMarks().size();

    }

    public void print() {
        System.out.println("\n\n");
        System.out.println(student.getSurname());
        System.out.println(student.getName());
        System.out.println(student.getDOB());
        System.out.println(student.getStudentID());
        System.out.println(student.getAverageMark());
        System.out.println(subjectWithtMarkTransformation());

    }

}
