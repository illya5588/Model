package model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
//TODO create classes Teacher and Manager

public abstract class User {

    protected String surname; //1 -20 characters
    protected String name;
    protected LocalDate DOB; // > 15


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getSurname() {
        return surname;
    }


    public String getName() {
        return name;
    }

    public LocalDate getDOB() {
        return DOB;
    }


    public User(LocalDate DOB) {
        this.DOB = DOB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return surname.equals(user.surname) &&
                name.equals(user.name) &&
                DOB.equals(user.DOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, DOB);
    }

}
