package com.melashvili.employeemanager.model.mapper;

import com.melashvili.employeemanager.model.dto.EmployeeDTO;
import com.melashvili.employeemanager.model.lib.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public static Employee dtoToEmployeeDTO(EmployeeDTO dto) {
        Employee employee = new Employee();

        employee.setEmployeeFirstName(dto.getEmployeeFirstName());
        employee.setEmployeeLastName(dto.getEmployeeLastName());
        employee.setAdmin(dto.getAdmin());
        employee.setSector(dto.getSector());
        employee.setTier(dto.getTier());

        return employee;
    }

    public static EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployeeFirstName(employee.getEmployeeFirstName());
        employeeDTO.setEmployeeLastName(employee.getEmployeeLastName());
        employeeDTO.setAdmin(employee.getAdmin());
        employeeDTO.setSector(employee.getSector());
        employeeDTO.setTier(employee.getTier());

        return employeeDTO;
    }
}
