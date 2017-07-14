package com.QueuePrograms;

/**
 * Created by 212561694 on 4/13/2017.
 */
public class Student {

    String firstName;
    String lastName;
    int studId;
    int marks;

    public Student(String firstName, String lastName, int studId, int marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studId = studId;
        this.marks = marks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
