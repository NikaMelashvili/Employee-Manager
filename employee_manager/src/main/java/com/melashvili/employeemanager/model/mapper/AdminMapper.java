package com.melashvili.employeemanager.model.mapper;

import com.melashvili.employeemanager.model.dto.AdminDTO;
import com.melashvili.employeemanager.model.lib.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    public static Admin dtoToAdmin(AdminDTO dto) {
        Admin admin = new Admin();
        admin.setAdminFirstName(dto.getAdminFirstName());
        admin.setAdminLastName(dto.getAdminLastName());
        admin.setAdminEmail(dto.getAdminEmail());
        admin.setAdminPassword(dto.getAdminPassword());

        return admin;
    }

    public static AdminDTO adminToAdminDTO(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setAdminFirstName(admin.getAdminFirstName());
        adminDTO.setAdminLastName(admin.getAdminLastName());
        adminDTO.setAdminEmail(admin.getAdminEmail());
        adminDTO.setAdminPassword(admin.getAdminPassword());

        return adminDTO;
    }
}
