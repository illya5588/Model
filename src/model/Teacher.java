package model;

import java.time.LocalDate;


public class Teacher extends User {
    protected String department;

    @Override
    public String toString() {
        return "Teacher{" +
                "Full Name  " + this.makeFullName() +
                ",  department='" + department + '\'' +
                " DOB=" + DOB +
                '}';
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    protected Teacher() {
        super(LocalDate.now());
    }

    public Teacher(String surname, String name, LocalDate DOB) {
        super(DOB);
        this.surname = surname;
        this.name = name;
        this.DOB = DOB;
    }

    public String makeFullName() {
        StringBuilder sb = new StringBuilder(surname);
        sb.append(" ").append(name.charAt(0)).append(".");


        return sb.toString();
    }
}
