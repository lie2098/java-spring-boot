package com.lye.cruddemo.controller;

import com.lye.cruddemo.model.Employee;
import com.lye.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.fetchAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.fetchById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable Long id, Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @PatchMapping("/{id}")
    public Employee updatePartialEmployeeById(@PathVariable Long id, @RequestBody Map<String, Object> employee) {
        return employeeService.modifyEmployeeById(id, employee);
    }

    @DeleteMapping("{id}")
    public String removeEmployeeById(@PathVariable Long id) {
        return employeeService.deleteById(id);
    }
}
