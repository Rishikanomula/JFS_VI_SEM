package com.skillnext2;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();

            // Add Student
            Student s1 = new Student("Ravi Kumar", "ravi@gmail.com", "AI & ML");
            dao.addStudent(s1);
            System.out.println("Student Added Successfully!");

            // Fetch Students
            List<Student> students = dao.getAllStudents();
            for (Student s : students) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

