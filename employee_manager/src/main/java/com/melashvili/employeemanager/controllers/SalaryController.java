package com.melashvili.employeemanager.controllers;

import com.melashvili.employeemanager.model.lib.Salary;
import com.melashvili.employeemanager.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/get/salary")
    public ResponseEntity<List<Salary>> getAllSalaries(){
        List<Salary> salaries = salaryService.getAllSalaries();
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

    @GetMapping("/get/salary/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable Long id){
        Salary salary = salaryService.getSalaryById(id);
        return new ResponseEntity<>(salary, HttpStatus.OK);
    }

    @PostMapping("/post/salary")
    public ResponseEntity<Void> addSalary(@RequestBody Salary salary){
        salaryService.saveSalary(salary);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/put/salary/{id}")
    public ResponseEntity<Void> updateSalary(@PathVariable Long id,
                                             @RequestBody Salary salary){
        salaryService.updateSalaryById(id, salary);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/salary/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable Long id){
        salaryService.deleteSalaryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
