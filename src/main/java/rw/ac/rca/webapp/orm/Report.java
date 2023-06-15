
package rw.ac.rca.webapp.orm;
public class Report {
    private String courseName;
    private String courseCode;
    private int totalStudents;
    private double averageGrade;
    // Add any additional attributes as per your report requirements

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    // Constructor, getters, and setters for the attributes
}
