package com.example.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value="/create")
    String createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value="/update/{id}")
    String updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value="/delete/{id}")
    String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

}
