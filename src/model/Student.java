package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;


//TODO validate all fields
//TODO create method that adds mark for certain subject for student
//TODO change average mark when mark is added or updated
//TODO create one more repo for this project
public class Student extends User {


    UUID studentID;
    public float avarageMark; // > 0
    private Map<Subject, Integer> marks;

    public Map<Subject, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<Subject, Integer> marks) {
        this.marks = marks;
    }


//    private Student() {
//    }

    public Student(String surname, String name, float avarageMark, LocalDate date) {
        super(date);

        List<String> errorMessage = new ArrayList<>();
        if (surname.length() < 20) {
            this.surname = surname;
        } else {
            errorMessage.add("Surname length is more than 20!");
        }
        if (name.length() < 15) {
            this.name = name;
        } else {
            errorMessage.add("Name length is more than 15!");
        }
        if (avarageMark > 0) {
            this.avarageMark = avarageMark;
        } else {
            errorMessage.add("Avarage mark required to be more than 0 !");
        }
        this.DOB = date;
        if (LocalDate.now().getYear() - DOB.getYear() <= 15) {
            errorMessage.add("Student age is less than 15 !");
        }
        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage.toString());
        }
    }


    public int age() {  //SOLID


        LocalDate today = LocalDate.now();
        Period result = Period.between(DOB, today);
        int age = result.getYears();

        return age;
    }

    public void markUpdate(Subject subject, int mark, Map<Subject, Integer> marks) {

        marks.put(subject, mark);
        this.setMarks(marks);
        this.countAvarageMark(marks);

    }


    public void countAvarageMark(Map<Subject, Integer> marks) {
        List<Integer> buf = new ArrayList<>(this.marks.values());
        int sum = 0;
        for (Integer i : buf) {
            sum += i;
        }
        this.avarageMark = sum / buf.size();

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
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", studentID='" + studentID + '\'' +
                ", avarageMark=" + avarageMark +
                ", DOB=" + DOB +
                '}';
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
}
