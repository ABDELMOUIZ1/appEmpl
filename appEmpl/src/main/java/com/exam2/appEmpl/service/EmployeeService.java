package com.exam2.appEmpl.service;

import com.exam2.appEmpl.model.Employee;
import com.exam2.appEmpl.model.EmployeeProject;
import com.exam2.appEmpl.model.Project;
import com.exam2.appEmpl.repo.EmployeeRepository;
import com.exam2.appEmpl.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Assigns a project to an employee and sets the implication percentage.
     * This method handles both adding a new project to an employee and updating
     * an existing project's implication if it's already assigned to the employee.
     *
     * @param employeeId the ID of the employee
     * @param projectId the ID of the project
     * @param implication the percentage of the employee's implication in the project
     */
    @Transactional
    public void assignProjectToEmployee(Long employeeId, Long projectId, int implication) {
        Employee employee = findById(employeeId);
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Optional<EmployeeProject> existingAssignment = employee.getProjects().stream()
                .filter(ep -> ep.getProject().getId().equals(projectId))
                .findFirst();

        if (existingAssignment.isPresent()) {
            existingAssignment.get().setImplication(implication);
        } else {
            EmployeeProject newAssignment = new EmployeeProject();
            newAssignment.setEmployee(employee);
            newAssignment.setProject(project);
            newAssignment.setImplication(implication);
            employee.getProjects().add(newAssignment.getProject());
        }

        save(employee);
    }

}
