package com.lye.cruddemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lye.cruddemo.model.Employee;
import com.lye.cruddemo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
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

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (ObjectUtils.isEmpty(employee)) {
            throw new RuntimeException("Employee not Found -- id: " + id);
        }

        return employee;
    }

    @Transactional
    public Employee addNewEmployee(Employee employee) {
        employee.setId(null);
        return save(employee);
    }

    @Transactional
    public Employee update(long id, Employee employee) {
        Employee currEmployee = findById(id);

        if (ObjectUtils.isEmpty(currEmployee)) {
            throw new RuntimeException("Employee not Found -- id: " + id);
        }
        employee.setId(id);

        return save(employee);
    }

    @Transactional
    public String deleteById(long id) {
        Employee currEmployee = findById(id);

        if( ObjectUtils.isEmpty(currEmployee)) {
            throw new RuntimeException("Employee not Found -- id: " + id);
        }

        employeeRepository.deleteById(id);

        return "Deleted Employee -- id: " + id;
    }

    @Transactional
    public Employee patchEmployee(long id, Map<String, Object> employeePayload) {
        Employee currEmployee = findById(id);

        if (ObjectUtils.isEmpty(employeePayload)) {
            throw new RuntimeException("Employee not Found -- id: " + id);
        }

        if (employeePayload.containsKey("id")) {
            throw new RuntimeException("Employee is not Allowed in the Request Body -- " + id);
        }

        Employee newEmployee = applyPatch(employeePayload, currEmployee);

        return save(newEmployee);
    }

    private Employee applyPatch(Map<String, Object> employeePayload, Employee employee) {
        ObjectNode employeePayloadJson = objectMapper.convertValue(employeePayload, ObjectNode.class);
        ObjectNode employeeJson = objectMapper.convertValue(employee, ObjectNode.class);

        employeeJson.setAll(employeePayloadJson);

        return objectMapper.convertValue(employeeJson, Employee.class);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
