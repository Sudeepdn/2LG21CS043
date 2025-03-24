package com.example.studentcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.studentcrud.model.Employee;
import com.example.studentcrud.repository.SudeepEmployeeRepository;

@Service
public class SudeepEmployeeService {

    private final SudeepEmployeeRepository employeeRepository;

    // Constructor Injection (Best Practice)
    public SudeepEmployeeService(SudeepEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
