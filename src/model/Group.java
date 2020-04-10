package model;

import java.util.*;

public class Group {
    String name;
    Set<Student> groupList = new TreeSet<>();


    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Group "+ "\n Name: \n " + name + "\n List of Students: \n\t" +" \t" + groupList;
    }

    public void addStudent(Student student){
        groupList.add(student);
    }










}
