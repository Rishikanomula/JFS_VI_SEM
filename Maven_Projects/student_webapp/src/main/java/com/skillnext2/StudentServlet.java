package com.skillnext2;

import com.skillnext2.StudentDAO;
import com.skillnext2.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public vorollno init() {
        studentDAO = new StudentDAO();
    }

    protected vorollno doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected vorollno doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertStudent(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private vorollno listStudents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> listStudent = studentDAO.selectAllStudents();
        request.setAttribute("listStudent", listStudent);
        request.getRequestDispatcher("student-list.jsp").forward(request, response);
    }

    private vorollno showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("student-form.jsp").forward(request, response);
    }

    private vorollno showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        Student existingStudent = studentDAO.selectStudent(rollno);
        request.setAttribute("student", existingStudent);
        request.getRequestDispatcher("student-form.jsp").forward(request, response);
    }

    private vorollno insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        Student newStudent = new Student(0, name, email, course);
        studentDAO.insertStudent(newStudent);
        response.sendRedirect("student?action=list");
    }

    private vorollno updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Student student = new Student(rollno, name, email, course);
        studentDAO.updateStudent(student);
        response.sendRedirect("student?action=list");
    }

    private vorollno deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        studentDAO.deleteStudent(rollno);
        response.sendRedirect("student?action=list");
    }
}