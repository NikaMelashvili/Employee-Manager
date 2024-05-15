package com.melashvili.employeemanager.model.dto;

import lombok.Data;

@Data
public class AdminDTO {
    private Long adminId;
    private String adminFirstName;
    private String adminLastName;
    private String adminEmail;
    private String adminPassword;
}
