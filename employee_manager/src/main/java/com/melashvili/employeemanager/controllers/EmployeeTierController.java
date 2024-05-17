package com.melashvili.employeemanager.controllers;

import com.melashvili.employeemanager.model.dto.EmployeeTierDTO;
import com.melashvili.employeemanager.model.lib.EmployeeTier;
import com.melashvili.employeemanager.services.EmployeeTierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeTierController {

    private final EmployeeTierService employeeTierService;

    @Autowired
    public EmployeeTierController(EmployeeTierService employeeTierService) {
        this.employeeTierService = employeeTierService;
    }

    @GetMapping("/get/tiers")
    public ResponseEntity<List<EmployeeTierDTO>> getAllEmployeeTiers() {
        List<EmployeeTierDTO> tiers = employeeTierService.getAllEmployeeTiers();
        return new ResponseEntity<>(tiers, HttpStatus.OK);
    }

    @GetMapping("/get/tiers/{id}")
    public ResponseEntity<EmployeeTierDTO> getEmployeeTierById(@PathVariable Long id) {
        EmployeeTierDTO tier = employeeTierService.getEmployeeTierById(id);
        return new ResponseEntity<>(tier, HttpStatus.OK);
    }

    @PostMapping("/post/tiers")
    public ResponseEntity<Void> addEmployeeTier(@RequestBody EmployeeTierDTO employeeTier) {
        employeeTierService.addEmployeeTier(employeeTier);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/put/tiers/{id}")
    public ResponseEntity<Void> updateTier(@PathVariable Long id,
                                           @RequestBody EmployeeTierDTO employeeTier) {
        employeeTierService.updateEmployeeTierById(id, employeeTier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/tiers/{id}")
    public ResponseEntity<Void> deleteEmployeeTier(@PathVariable Long id) {
        employeeTierService.deleteEmployeeTierById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
