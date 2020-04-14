package service;

import model.Group;
import model.Student;
import java.util.*;


public class GroupService {
    protected Group group;


    public GroupService(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }




    public List<Student> sortedBySurname() {
        List<Student> buf = new ArrayList<>(this.group.getGroupList());
        Collections.sort(buf, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getSurname().equals(o2.getSurname())) {
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        return buf;
    }


    public List<Student> sortedByMark() {
        List<Student> buf = new ArrayList<>(this.group.getGroupList());
        Collections.sort(buf, (o1, o2) -> {
            return Double.compare(o1.getAverageMark(), o2.getAverageMark());
        });
        return buf;
    }



    public List<Student> listOfStudentByAvMark(int mark) {
        List<Student> buf = new ArrayList<>();
        for (Student i : this.group.getGroupList()) {
            if (i.getAverageMark() >= mark) {
                buf.add(i);
            }
        }
        return buf;
    }



    public List<Student> listOfStudentByGenAvMark(int mark) {
        List<Student> buf = new ArrayList<>();
        for (Student student : this.group.getGroupList()) {
            if (student.getAverageMark() >= mark) {
                boolean isEligable = true;
                for (Integer value : student.getMarks().values()) {
                    if (value < mark) {
                        isEligable = false;
                        break;
                    }

                }
                if (isEligable) {
                    buf.add(student);
                }
            }
        }
        return buf;
    }



    public void deleteUStudent(){
            Iterator itr = getGroup().getGroupList().iterator();
            while (itr.hasNext())
            {
                Student student = (Student) itr.next();
                for (Integer i:student.getMarks().values()) {
                    if(i<50){
                        itr.remove();
                    }

                }
            }

        }
    }

