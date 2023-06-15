package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.*;
import rw.ac.rca.webapp.dao.impl.*;
import rw.ac.rca.webapp.orm.Instructor;
import rw.ac.rca.webapp.orm.Parent;
import rw.ac.rca.webapp.util.UserRole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Dashboard
 */

public class Dashboard extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
       StudentDAO studentDAO = StudentDAOImpl.getInstance();
       CourseDAO courseDAO = CourseDAOImpl.getInstance();
       EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();
       InstructorDAO instructorDAO = InstructorDAOImpl.getInstance();
       ManagerDAO managerDAO = ManagerDAOImpl.getInstance();
       ParentDAO parentDAO = ParentDAImpl.getInstance();
       UserDAO userDAO = UserDAOImpl.getInstance();

       HttpSession httpSession = request.getSession();
       UserRole[] userRoles = UserRole.values();
       httpSession.setAttribute("userRoles", userRoles);
       if(userDAO.getAllUsers() == null){
           httpSession.setAttribute("users", 0);
       }else{
           httpSession.setAttribute("users", employeeDAO.getAllEmployees().size());
       }
       if(employeeDAO.getAllEmployees() == null){
           httpSession.setAttribute("employees", 0);
       }else{
           httpSession.setAttribute("employees", employeeDAO.getAllEmployees().size());
       }
       if(parentDAO.getAllParents() == null){
           httpSession.setAttribute("parents", 0);
       }else{
           httpSession.setAttribute("parents", parentDAO.getAllParents().size());
       }
       if(managerDAO.getAllManagers() == null){
           httpSession.setAttribute("managers", 0);
       }else{
           httpSession.setAttribute("managers", managerDAO.getAllManagers().size());
       }
       if(studentDAO.getAllStudents() == null){
           httpSession.setAttribute("instructors", 0);
       }else{
           httpSession.setAttribute("instructors", instructorDAO.getAllInstructors().size());
       }
       if(courseDAO.getAllCourses() == null){
           httpSession.setAttribute("courses", 0);
       }else{
           httpSession.setAttribute("courses", courseDAO.getAllCourses().size());
       }
       if(studentDAO.getAllStudents() == null){
           httpSession.setAttribute("studentsNumber", 0);
       }else{
           httpSession.setAttribute("studentsNumber", studentDAO.getAllStudents().size());
       }
       request.getRequestDispatcher("WEB-INF/pages/dashboard.jsp").forward(
               request, response);
   }
}
