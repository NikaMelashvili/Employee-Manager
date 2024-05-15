package com.melashvili.employeemanager.model.dto;

import com.melashvili.employeemanager.model.lib.Admin;
import com.melashvili.employeemanager.model.lib.EmployeeTier;
import com.melashvili.employeemanager.model.lib.Sector;
import lombok.Data;

@Data
public class EmployeeDTO {
    private String employeeFirstName;
    private String employeeLastName;
    private Admin admin;
    private Sector sector;
    private EmployeeTier tier;
}
