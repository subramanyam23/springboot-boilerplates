package com.searce.boilerplates.service;

import com.searce.boilerplates.dao.EmployeeRepository;
import com.searce.boilerplates.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository dao;

    public List<Employee> getAllEmployees() {
        try {
            return this.dao.findAll();
        } catch (Exception exception) {
            return null;
        }
    }

    public boolean addNewEmployee(Employee employee) {
        try {
            this.dao.save(employee);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
