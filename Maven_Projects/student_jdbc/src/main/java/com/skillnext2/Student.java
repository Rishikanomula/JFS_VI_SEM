package com.skillnext2;

public class Student {
    private int rollno;
    private String name;
    private String email;
    private String course;

    // Constructors
    public Student() {}

    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public Student(int rollno, String name, String email, String course) {
        this.rollno = rollno;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name +
               ", email=" + email + ", course=" + course + "]";
    }
}

