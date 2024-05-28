package com.melashvili.employeemanager.model.dto;

import lombok.Data;

@Data
public class TaskImageDTO {
    private Long id;
    private String imageName;
    private byte[] taskImage;
}
