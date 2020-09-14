package com.codeprince.employeemanagementsystem.controllers;

import com.codeprince.employeemanagementsystem.models.Employee;
import com.codeprince.employeemanagementsystem.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Display the list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        model.addAttribute("employee", employee);
        return "index";
    }

    @GetMapping("showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // Create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // Save Employee to the database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

}