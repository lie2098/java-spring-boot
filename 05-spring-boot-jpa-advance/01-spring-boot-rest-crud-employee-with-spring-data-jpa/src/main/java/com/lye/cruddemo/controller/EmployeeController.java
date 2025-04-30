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
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateExistingEmployee(@PathVariable long id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable long id) {
        return employeeService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Employee partiallyUpdateExistingEmployee(@PathVariable long id, @RequestBody Map<String, Object> employee) {
        return employeeService.patchEmployee(id, employee);
    }
}
