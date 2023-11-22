package com.searce.boilerplates.controller;

import com.searce.boilerplates.model.Employee;
import com.searce.boilerplates.model.response.Response;
import com.searce.boilerplates.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllemployees() {
        List<Employee> employees = this.employeeService.getAllEmployees();

        if (employees != null) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            Response errorRes = new Response();
            errorRes.setCode(53123);
            errorRes.setMessage("Database Error");
            errorRes.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(errorRes, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        boolean isAdded = this.employeeService.addNewEmployee(employee);
        Response response = new Response();

        System.out.println("/employee/add: " + employee);

        if (isAdded) {
            response.setCode(200);
            response.setStatus(HttpStatus.CREATED);
            response.setMessage("Successfully Added the employee to database");
        } else {
            response.setCode(500);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage("Internal Server Error");
        }

        return new ResponseEntity<>(response, response.getStatus());
    }
}
