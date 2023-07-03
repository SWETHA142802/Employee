package com.employee.Employee.entity;

import jakarta.persistence.*;

@Entity
@Table
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email_id")
    private String email_id;
    @Column(name = "age")
    private String age;

    public EmployeeEntity(){
    }
    public EmployeeEntity(long id, String name, String gender, String email_id, String age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email_id = email_id;
        this.age = age;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
