package rw.ac.rca.webapp.dao.impl;

import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.orm.Student;

import java.util.List;

public class StudentDAOImpl extends DAO implements StudentDAO {
    private static StudentDAOImpl instance;

    private StudentDAOImpl() {

    }

    public static StudentDAOImpl getInstance() {
        if (instance == null) {
            return new StudentDAOImpl();
        } else {
            return instance;
        }
    }

    @Override
    public Student saveStudent(Student student) {
        try {
            begin();
            getSession().save(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Student updateStudent(Student student) {
        try {
            begin();
            getSession().update(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Student saveOrUpdateStudent(Student student) {
        try {
            begin();
            getSession().saveOrUpdate(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public boolean deleteStudent(Student student) {
        try {
            begin();
            getSession().delete(student);
            commit();
            return true;
        } catch (Exception e) {
            rollback();
            return false;
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            begin();
            Student student = (Student) getSession().get(Student.class, studentId);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Student getStudentByUsername(String username) {
        try {
            begin();
            Student student = (Student) getSession().get(Student.class, username);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Student getStudentByEmail(String email) {
        try {
            begin();
            Student student = (Student) getSession().get(Student.class, email);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        try {
            begin();
            List<Student> students = getSession().createQuery("from Student").list();
            commit();
            return students;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }
}
