package com.lye.cruddemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lye.cruddemo.exception.EmployeeException;
import com.lye.cruddemo.model.Employee;
import com.lye.cruddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
    }

    public List<Employee> fetchAll() {
        return employeeRepository.findAll();
    }

    public Employee fetchById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        validateEmployee(id, employee);

        return employee;
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(null);

        return save(employee);
    }

    public Employee updateEmployeeById(Long id, Employee employeePayload) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        validateEmployee(id, employee);

        employeePayload.setId(id);

        return save(employeePayload);
    }


    public Employee modifyEmployeeById(Long id, Map<String, Object> employeePayload) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        validateEmployee(id, employee);

        employee = mapEmployee(employeePayload, employee);

        return save(employee);
    }

    public String deleteById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        validateEmployee(id, employee);

        employeeRepository.delete(employee);

        return "Employee with id " + id + " deleted successfully";
    }

    private Employee mapEmployee(Map<String, Object> employeePayload, Employee employee) {
        ObjectNode employeePayloadJson = objectMapper.valueToTree(employeePayload);
        ObjectNode employeeJson = objectMapper.valueToTree(employee);

        employeeJson.setAll(employeePayloadJson);

        employee = objectMapper.convertValue(employeeJson, Employee.class);
        return employee;
    }

    private Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    private static void validateEmployee(Long id, Employee employee) {
        if (ObjectUtils.isEmpty(employee)) {
            throw new EmployeeException("Employee with id " + id + " not found");
        }
    }
}
