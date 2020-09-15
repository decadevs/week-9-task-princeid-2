package com.codeprince.employeemanagementsystem.controllers;

import com.codeprince.employeemanagementsystem.models.Employee;
import com.codeprince.employeemanagementsystem.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Display the list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
//        Employee employee = new Employee();
//        model.addAttribute("employee", employee);
        return findPaginated(1, model);
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // Save Employee to the database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value = "id") long id, Model model) {
        // Get employee by Id from the service
        Employee employee = employeeService.getEmployeeById(id);

        // Set the retrieved employee object to the model to prepopulate the form
        model.addAttribute("employee", employee);
//        model.addAttribute("isAdd", false);
        return "update_employee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        System.out.println("ENTERED HERE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>+++++++++++??????????????????");
        // Save Employee to the database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {

        // Call delete employee method from the employee service
         employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        int pageSize = 6;
        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
        List<Employee> listEmployees = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listEmployees", listEmployees);
        return "index";

    }

}