package com.exam2.appEmpl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.exam2.appEmpl.service.EmployeeService;
import com.exam2.appEmpl.model.Employee;

import java.util.List;

@RestController
@RequestMapping("/api/devops")
public class DevOpsController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }
}
