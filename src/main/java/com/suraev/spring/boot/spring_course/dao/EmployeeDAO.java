package com.suraev.spring.boot.spring_course.dao;



import com.suraev.spring.boot.spring_course.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

/*    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);


    public void deleteEmployee(int id);*/
}
