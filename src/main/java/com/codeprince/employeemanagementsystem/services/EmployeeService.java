package com.codeprince.employeemanagementsystem.services;

import com.codeprince.employeemanagementsystem.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
}
