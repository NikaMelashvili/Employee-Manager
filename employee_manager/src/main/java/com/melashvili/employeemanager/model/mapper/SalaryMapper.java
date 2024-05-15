package com.melashvili.employeemanager.model.mapper;

import com.melashvili.employeemanager.model.dto.SalaryDTO;
import com.melashvili.employeemanager.model.lib.Salary;
import org.springframework.stereotype.Component;

@Component
public class SalaryMapper {

    public static Salary dtoToSalary(SalaryDTO dto) {
        Salary salary = new Salary();

        salary.setEmployee(dto.getEmployee());
        salary.setGrossSalary(dto.getGrossSalary());
        salary.setNetSalary(dto.getNetSalary());

        return salary;
    }

    public static SalaryDTO salaryToDto(Salary salary) {
        SalaryDTO dto = new SalaryDTO();

        dto.setEmployee(salary.getEmployee());
        dto.setGrossSalary(salary.getGrossSalary());
        dto.setNetSalary(salary.getNetSalary());

        return dto;
    }
}
