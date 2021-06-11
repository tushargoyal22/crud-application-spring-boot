package com.example.demo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // This tells Hibernate to make a table out of this class
@Table

public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private LocalDate date;
    private Integer dob;

    public  Student(){}

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate date,
                   Integer dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate date, Integer dob) {
        this.name = name;
        this.email = email;
        this.date = date;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getDob() {
        return dob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDob(Integer dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", dob=" + dob +
                '}';
    }
}
