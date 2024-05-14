package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.Admin;
import com.melashvili.employeemanager.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        Iterable<Admin> temp = adminRepository.findAll();
        List<Admin> admins = new ArrayList<>();
        for (Admin admin : temp) {
            admins.add(admin);
            System.out.println(admin.toString());
        }
        return admins;
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public void updateAdminById(Long id, Admin updatedAdmin) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);

        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();

            admin.setAdminFirstName(updatedAdmin.getAdminFirstName());
            admin.setAdminLastName(updatedAdmin.getAdminLastName());
            admin.setAdminEmail(updatedAdmin.getAdminEmail());
            admin.setAdminPassword(updatedAdmin.getAdminPassword());

            adminRepository.save(admin);
        } else {
            System.out.println("Admin not found");
        }
    }

    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }
}
