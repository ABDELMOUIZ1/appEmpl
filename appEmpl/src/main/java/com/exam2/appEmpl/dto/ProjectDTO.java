package com.exam2.appEmpl.dto;


import java.util.Set;

public class ProjectDTO {
    private Long id;
    private String name;
    private double budget;
    private Set<Long> employeeIds; // Only the IDs to avoid circular references

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String name, double budget, Set<Long> employeeIds) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.employeeIds = employeeIds;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Set<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(Set<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }
}
