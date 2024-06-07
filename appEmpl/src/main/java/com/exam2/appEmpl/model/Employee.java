package com.exam2.appEmpl.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Post> skills = new HashSet<>();


    @OneToMany(mappedBy = "employee")
    private Set<EmployeeProject> projects = new HashSet<>();



}
