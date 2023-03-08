package org.aptech.controllers;

import org.aptech.entities.Company;
import org.aptech.entities.Course;
import org.aptech.entities.Employee;
import org.aptech.enums.Action;
import org.aptech.services.EmployeeService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {

    @EJB
    EmployeeService<Employee> employeeService;

    @EJB
    EmployeeService<Company> companyService;

//    @Override
//    public void init() throws ServletException {
//        super.init();
//        employeeService.setType(Employee.class);
//        companyService.setType(Company.class);
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "ADD" : request.getParameter("action");

        if(action.equalsIgnoreCase("ADD")){
            request.getServletContext().getRequestDispatcher("/WEB-INF/Insert.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("SEARCH")) {

            request.getServletContext().getRequestDispatcher("/WEB-INF/SearchEmployee.jsp").forward(request, response);
        }
        else if (action.equalsIgnoreCase("DELETE")) {

            request.getServletContext().getRequestDispatcher("/WEB-INF/Delete.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "ADD" : request.getParameter("action");
        if(action.equalsIgnoreCase("ADD")){
            addEmployee(request, response);

        } else if (action.equalsIgnoreCase("SEARCH")) {

            employeeService.setType(Employee.class);
            String Id = request.getParameter("empId");
            Employee employee = employeeService.getEntityById(Id);
            request.setAttribute("emp", employee);
            request.getServletContext().getRequestDispatcher("/WEB-INF/Result.jsp").forward(request, response);
        }
        else if (action.equalsIgnoreCase("DELETE")) {

            employeeService.setType(Employee.class);
            String Id = request.getParameter("empId");

            if(employeeService.deleteEntity(Id)){
                response.getWriter().write("Successfully");
            }else {
                response.getWriter().write("Failed");
            }
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            String empId = request.getParameter("empId");
            String empName = request.getParameter("empName");
            String comId = request.getParameter("comId");
            String comIdNew = request.getParameter("comIdNew");
            String comName = request.getParameter("comName");

            String courseId = request.getParameter("courseId");
            String courseName = request.getParameter("courseName");

            Company newCompany = new Company();
            newCompany.setCompanyId(comIdNew);
            newCompany.setCompanyName(comName);

            companyService.addEntity(newCompany);

            Company company = new Company();
            company.setCompanyId(comId);

            Set<Company> companies = new HashSet<>();
            companies.add(company);
            companies.add(newCompany);

            Employee employee = new Employee();
            Course course = new Course();
            course.setCourseId(courseId);
            course.setCourseName(courseName);
            course.setEmployee(employee);

            Set<Course> couresSet = new HashSet<>();
            couresSet.add(course);

            employee.setEmployeeId(empId);
            employee.setEmployeeName(empName);
            employee.setCompanies(companies);
            employee.setCourse(couresSet);

            if(employeeService.addEntity(employee)){
                response.getWriter().write("Successfully added");
//                request.getServletContext().getRequestDispatcher("/WEB-INF/SearchEmployee.jsp").forward(request, response);
            }else {
                response.getWriter().write("Failed to add");
            }
    }
}
