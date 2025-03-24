package com.example.studentcrud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String employeeShift;
    private String shiftWeek;
    private String shifttime;

    public Employee() {
    }

    public Employee(String name, String email, String phone, String address, String gender, String employeeShift, String shiftWeek) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.employeeShift = employeeShift;
        this.shiftWeek = shiftWeek;
        this.shifttime = shifttime;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmployeeShift() {
        return employeeShift;
    }

    public void setEmployeeShift(String employeeShift) {
        this.employeeShift = employeeShift;
    }

    public String getShiftWeek() {
        return shiftWeek;
    }

    public void setShiftWeek(String shiftWeek) {
        this.shiftWeek = shiftWeek;
    }
    public String getShifttime() {
        return shifttime;
    }

    public void setShifttime(String shifttime) {
        this.shifttime = shifttime;
    }
}
