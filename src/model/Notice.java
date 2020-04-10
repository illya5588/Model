package model;

import java.time.LocalDate;

public class Notice  {
    private Student student;

    public Notice(Student student)  {
       this.student = student;
    }

    @Override
    public String toString() {
        return "Student  " + this.student+ '\n' + this.student.subjectWithtMarkTransformation();


    }


//   // public void genNotice(Student student) {
//        StringBuilder markbook = student.printMarkTransformation();
//        System.out.println(this.toString() + markbook + " }");
//    }


}
