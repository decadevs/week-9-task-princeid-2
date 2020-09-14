package com.codeprince.employeemanagementsystem.serviceImpl;

import com.codeprince.employeemanagementsystem.models.Employee;
import com.codeprince.employeemanagementsystem.repositories.EmployeeRepository;
import com.codeprince.employeemanagementsystem.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }
}