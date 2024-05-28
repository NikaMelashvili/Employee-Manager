package com.melashvili.employeemanager.model.dto;

import com.melashvili.employeemanager.model.lib.Admin;
import com.melashvili.employeemanager.model.lib.Employee;
import lombok.Data;

import java.util.List;

@Data
public class TaskDTO {
    private Admin admin;
    private List<Employee> employee;
    private String taskName;
    private String taskDescription;
    private Long taskImage;
}
