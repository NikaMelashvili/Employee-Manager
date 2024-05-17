package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.dto.AdminDTO;
import com.melashvili.employeemanager.model.lib.Admin;
import com.melashvili.employeemanager.model.mapper.AdminMapper;
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

    public List<AdminDTO> getAllAdmins() {
        Iterable<Admin> temp = adminRepository.findAll();
        List<Admin> admins = new ArrayList<>();
        for (Admin admin : temp) {
            admins.add(admin);
            System.out.println(admin.toString());
        }
        List<AdminDTO> adminDTOS = new ArrayList<>();
        for (Admin admin : admins) {
            adminDTOS.add(AdminMapper.adminToAdminDTO(admin));
        }

        return adminDTOS;
    }

    public AdminDTO getAdminById(Long id) {
        return AdminMapper.adminToAdminDTO(adminRepository.findById(id).orElse(null));
    }

    public void addAdmin(AdminDTO temp) {
        Admin admin = AdminMapper.dtoToAdmin(temp);
        adminRepository.save(admin);
    }

    public void updateAdminById(Long id, AdminDTO updatedAdmin) {
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
