package com.melashvili.employeemanager.model.dto;

import com.melashvili.employeemanager.model.lib.Employee;
import lombok.Data;

@Data
public class SalaryDTO {
    private Employee employee;
    private Long grossSalary;
    private Long netSalary;
}
