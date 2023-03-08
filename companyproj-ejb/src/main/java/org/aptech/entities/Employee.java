package org.aptech.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @Column(name = "EmployeeId",columnDefinition = "varchar(10)")
    private String employeeId;

    @Column(name = "EmployeeName",columnDefinition = "varchar(50)")
    private String employeeName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employe_company",
            joinColumns = @JoinColumn(name = "EmployeeId"),
            inverseJoinColumns = @JoinColumn(name = "CompanyId"))
    private  Set<Company> companies;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Course> course;

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Employee() {
    }
}
