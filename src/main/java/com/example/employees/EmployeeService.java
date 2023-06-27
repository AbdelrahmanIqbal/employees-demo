package com.example.employees;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    String createEmployee(Employee employee){
        try {
            employeeRepository.save(employee);
            return "Your employee number is #" + employee.getId();
        } catch(Exception e){
            return e.getMessage().toString();
        }
    }

    String updateEmployee(Employee employee){
        if (employeeRepository.existsById(employee.getId())) {
            try {
                employeeRepository.save(employee);
                return "Employee #" + employee.getId() + " has been updated";
            } catch(Exception e){
                return e.getMessage().toString();
            }
        } else{
            return "Employee doesn't exist.";
        }
    }

    String deleteEmployee(int id){
        if (employeeRepository.existsById(id)) {
            Employee employee =  employeeRepository.findById(id).orElseThrow();
            try {
                employeeRepository.delete(employee);
                return "Employee #" + id + " has been deleted.";
            } catch(Exception e){
                return e.getMessage().toString();
            }
        } else {
            return "Employee does not exist.";
        }
    }

    List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    Employee getEmployee(int id){
        return employeeRepository.findById(id).orElseThrow();
    }

}
