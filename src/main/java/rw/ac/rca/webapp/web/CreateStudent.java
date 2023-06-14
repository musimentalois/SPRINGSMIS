package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CreateStudent extends HttpServlet {
    private final StudentDAO studentDAO = StudentDAOImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        request.getRequestDispatcher("WEB-INF/pages/createstudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Date dateOfBirth = Util.parseDate(req.getParameter("dateOfBirth"));

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dateOfBirth);

        Student savedStudent = studentDAO.saveStudent(student);

        if (savedStudent != null) {
            req.getSession().setAttribute("student", savedStudent);
            try {
                req.getRequestDispatcher("WEB-INF/pages/createstudent.jsp").forward(req, resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            req.getSession().setAttribute("error", "Failed to save student");
            req.getRequestDispatcher("WEB-INF/pages/error.jsp").forward(req, resp);
        }
    }
}
