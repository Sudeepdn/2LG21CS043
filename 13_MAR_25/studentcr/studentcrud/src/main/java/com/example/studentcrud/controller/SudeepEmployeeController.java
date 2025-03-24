package com.example.studentcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.studentcrud.model.Employee;
import com.example.studentcrud.service.SudeepEmployeeService;

import java.util.Optional;

@Controller
@RequestMapping("/sudeep")
public class SudeepEmployeeController {

    @Autowired
    private SudeepEmployeeService employeeService;

    @GetMapping({"", "/", "/list"})
    public String list(Model model) {
        model.addAttribute("employee", employeeService.listAll());
        return "employee/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/sudeep/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if (employee.isPresent()) {
            employeeService.deleteEmployee(id);
        }
        return "redirect:/sudeep/list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "employee/edit";
        }
        return "redirect:/sudeep/list"; // Redirect if not found (consider adding an error message)
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeService.saveEmployee(employee);
        return "redirect:/sudeep/list";
    }
}
