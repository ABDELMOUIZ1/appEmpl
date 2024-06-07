package com.exam2.appEmpl.dto;


import java.util.Set;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Set<String> skills; // Store skills as String for simplicity
    private Set<Long> projectIds; // Only the IDs to avoid circular references

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, String email, Set<String> skills, Set<Long> projectIds) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.projectIds = projectIds;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<Long> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(Set<Long> projectIds) {
        this.projectIds = projectIds;
    }
}
