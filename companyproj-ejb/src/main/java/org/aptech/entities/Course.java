package org.aptech.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Course")
public class Course implements Serializable {

    @Id
    @Column(name = "CourseId", columnDefinition = "varchar(10)")
    private String courseId;

    @Column(name = "CourseName", columnDefinition = "varchar(100)")
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "EmployeeId", nullable = false)
    private Employee employee;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Course() {
    }
}
