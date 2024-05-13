package com.melashvili.employeemanager.controllers;

import com.melashvili.employeemanager.model.Admin;
import com.melashvili.employeemanager.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get")
public class MainController {
    private final AdminService adminService;

    @Autowired
    public MainController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public List<Admin> getAdmins() {
        return adminService.getAllAdmins();
    }
}
