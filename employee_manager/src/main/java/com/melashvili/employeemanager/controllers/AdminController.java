package com.melashvili.employeemanager.controllers;

import com.melashvili.employeemanager.model.lib.*;
import com.melashvili.employeemanager.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/get/admin")
    public ResponseEntity<List<Admin>> getAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/get/admin/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/post/admin")
    public ResponseEntity<Void> saveAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/put/admin/{id}")
    public ResponseEntity<Void> updateAdmin(@PathVariable Long id,
                            @RequestBody Admin admin) {
        adminService.updateAdminById(id, admin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/admin/{id}")
    public ResponseEntity<Void> deleteAdminById(@PathVariable Long id) {
        adminService.deleteAdminById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
