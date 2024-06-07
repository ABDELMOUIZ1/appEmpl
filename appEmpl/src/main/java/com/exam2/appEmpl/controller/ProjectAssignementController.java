package com.exam2.appEmpl.controller;

import com.exam2.appEmpl.model.Employee;
import com.exam2.appEmpl.model.Project;
import com.exam2.appEmpl.service.EmployeeService;
import com.exam2.appEmpl.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProjectAssignementController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/assign")
    @PreAuthorize("hasRole('MANAGER')")
    public String showAssignmentForm(Model model) {
        List<Employee> employees = employeeService.findAll();
        List<Project> projects = projectService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("projects", projects);
        model.addAttribute("assignment", new AssignmentForm());
        return "employeeAffectation";
    }

    @PostMapping("/assignEmployee")
    public String assignEmployee(@ModelAttribute AssignmentForm assignment) {
        // Logic to assign employee to project
        return "redirect:/";
    }

    public static class AssignmentForm {
        private Long employeeId;
        private Long projectId;
        private int implication;

        // Getters and Setters
    }
}
