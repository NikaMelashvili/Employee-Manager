package com.melashvili.employeemanager.model.lib;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Base64;

@Entity
@Table(name = "task_images")
@Data
public class TaskImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_name")
    private String imageName;

    @Lob
    @Column(name = "binary_data")
    private byte[] imageData;

    public void decodeBase64ToBytes(String base64Data) {
        String[] parts = base64Data.split(",");
        this.imageData = Base64.getDecoder().decode(parts[parts.length - 1]);
    }
}
