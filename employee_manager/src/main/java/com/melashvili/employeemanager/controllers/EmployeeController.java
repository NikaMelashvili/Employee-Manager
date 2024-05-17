package com.melashvili.employeemanager.controllers;

import com.melashvili.employeemanager.model.dto.AdminDTO;
import com.melashvili.employeemanager.model.dto.EmployeeDTO;
import com.melashvili.employeemanager.model.dto.EmployeeTierDTO;
import com.melashvili.employeemanager.model.dto.SectorDTO;
import com.melashvili.employeemanager.model.lib.Admin;
import com.melashvili.employeemanager.model.lib.Employee;
import com.melashvili.employeemanager.model.lib.EmployeeTier;
import com.melashvili.employeemanager.model.lib.Sector;
import com.melashvili.employeemanager.services.AdminService;
import com.melashvili.employeemanager.services.EmployeeService;
import com.melashvili.employeemanager.services.EmployeeTierService;
import com.melashvili.employeemanager.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/get/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/post/employees")
    public ResponseEntity<Void> saveEmployee(@RequestBody EmployeeDTO employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/put/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id,
                                               @RequestBody Employee employee) {
        employeeService.updateEmployeeById(id, employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
