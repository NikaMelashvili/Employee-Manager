package com.melashvili.employeemanager.model.mapper;

import com.melashvili.employeemanager.model.dto.EmployeeTierDTO;
import com.melashvili.employeemanager.model.lib.EmployeeTier;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTierMapper {

    public static EmployeeTier dtoToEmployeeTier(EmployeeTierDTO dto) {
        EmployeeTier employeeTier = new EmployeeTier();

        employeeTier.setTierName(dto.getTierName());
        employeeTier.setTierDescription(dto.getTierDescription());

        return employeeTier;
    }

    public static EmployeeTierDTO employeeTierToDto(EmployeeTier employeeTier) {
        EmployeeTierDTO dto = new EmployeeTierDTO();

        dto.setTierName(employeeTier.getTierName());
        dto.setTierDescription(employeeTier.getTierDescription());

        return dto;
    }
}
