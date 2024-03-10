package com.suraev.spring.boot.spring_course.dao;


import com.suraev.spring.boot.spring_course.entity.Employee;
import jakarta.persistence.EntityManager;
/*import org.hibernate.Session;
import org.hibernate.query.Query;*/
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class  EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;



    public List<Employee> getAllEmployees() {
       /* Session session= entityManager.unwrap(Session.class);


        Query<Employee> query=session.createQuery("from Employee", Employee.class);
        List<Employee> employeeList= query.getResultList();*/
        Query query =entityManager.createQuery("from Employee");
        List<Employee> employeeList = query.getResultList();


        return employeeList;
    }

    @Override
    public void saveEmployee(Employee employee) {
       /* Session session= entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);*/

        Employee newEmployee =entityManager.merge(employee);
        employee.setId(newEmployee.getId());

    }

    @Override
    public Employee getEmployee(int id) {
       /* Session session= entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);*/
        Employee employee= entityManager.find(Employee.class,id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        /*Session session=entityManager.unwrap(Session.class);
        Employee employee= session.get(Employee.class,id);
        session.delete(employee);*/

       /* Query<Employee>employeeQuery=session.createQuery("delete from Employee " +
                "where id=:employeeId");
        employeeQuery.setParameter("employeeId",id);
        employeeQuery.executeUpdate();*/

/*
        Query query= entityManager.createQuery("delete from Employee " +
                "where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();*/

        Employee employee=entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }


}
