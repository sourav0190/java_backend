package com.example.student.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_data")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "class_name", nullable = false)
    private String className;

    public Student() {}   // REQUIRED for JPA

    // Getters and Setters

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getClassName() { return className; }

    public void setClassName(String className) { this.className = className; }
}
