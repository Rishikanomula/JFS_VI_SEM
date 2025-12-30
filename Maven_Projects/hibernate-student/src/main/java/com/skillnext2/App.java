package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student CRUD Menu =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    insertStudent(new Student(name, email, course));
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    System.out.print("Enter RollNo to update: ");
                    int rollnoUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Course: ");
                    String newCourse = sc.nextLine();

                    updateStudent(rollnoUpdate, newCourse);
                    break;

                case 4:
                    System.out.print("Enter RollNo to delete: ");
                    int rollnoDelete = sc.nextInt();
                    deleteStudent(rollnoDelete);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    // Insert Student
    public static void insertStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(student);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully!");
    }

    // Display Students (Read)
    public static void displayStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Student> query = session.createQuery("FROM Student", Student.class);
        List<Student> students = query.list();

        for (Student s : students) {
            System.out.println("RollNo: " + s.getRollno() +
                               ", Name: " + s.getName() +
                               ", Email: " + s.getEmail() +
                               ", Course: " + s.getCourse());
        }

        session.close();
    }

    // Update Student
    public static void updateStudent(int rollno, String newCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, rollno);
        if (student != null) {
            student.setCourse(newCourse);
            session.update(student);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }

        tx.commit();
        session.close();
    }

    // Delete Student
    public static void deleteStudent(int rollno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, rollno);
        if (student != null) {
            session.delete(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }

        tx.commit();
        session.close();
    }
}