package com.skillnext2;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext2_db";
    private static final String USER = "root";
    private static final String PASSWORD = "shloknomula";

    // Insert Student
    public void addStudent(Student s) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO student(name, email, course) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCourse());

        ps.executeUpdate();
        con.close();
    }

    // Fetch All Students
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "SELECT * FROM student";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Student s = new Student(
                rs.getInt("rollno"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("course")
            );
            list.add(s);
        }

        con.close();
        return list;
    }
}

