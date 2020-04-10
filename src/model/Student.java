package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;


//TODO validate all fields
//TODO create two custom class exception (extends from runtime exception and extends from exception)
//TODO create class group, set Students, sort students by Average mark
public class Student extends User implements Comparable<Student> {


    UUID studentID;
    public float avarageMark; // > 0
    protected Map<Subject, Integer> marks;

    public Map<Subject, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<Subject, Integer> marks) {
        this.marks = marks;
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

        if (LocalDate.now().getYear() - date.getYear() > 15) {
            this.DOB = date;
        } else {
            throw new DateException("Student is too young! Student age should to be greater than 15!");
        }

    }


    public StringBuilder subjectWithtMarkTransformation() {
        StringBuilder sb = new StringBuilder();
        for (Subject key : this.marks.keySet()) {
            int value = this.marks.get(key);

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
        return 'F';


    }


    public int age() {


        LocalDate today = LocalDate.now();
        Period result = Period.between(DOB, today);
        int age = result.getYears();

        return age;
    }

    public void markUpdate(Subject subject, int mark) {

        this.marks.put(subject, mark);
        this.avarageMark = countAvarageMark();

    }


    public float countAvarageMark() {
        float sum = 0;
        for (Integer i : this.marks.values()) {
            sum += i;
        }
        return sum / this.marks.size();

    }


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

    public UUID genID() {    //UUID  xxxx-xxxx-xxxx-xxxx
        return this.studentID = UUID.randomUUID();


    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return super.toString().concat("\n average mark= " + String.valueOf(avarageMark).concat("\n\n"));

    }

    public String getName() {
        return name;
    }

    public UUID getStudentID() {
        return studentID;
    }

    public float getAvarageMark() {
        return avarageMark;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void print() {
        System.out.println("\n\n");

        System.out.println(this.getSurname());
        System.out.println(this.getName());
        System.out.println(this.getStudentID());
        System.out.println(this.getAvarageMark());

    }

    @Override
    public int compareTo(Student o) {
        if (this.avarageMark > o.getAvarageMark()) {
            return 1;
        } else if (this.avarageMark < o.getAvarageMark()) {
            return -1;


        } else return 0;
    }
}
