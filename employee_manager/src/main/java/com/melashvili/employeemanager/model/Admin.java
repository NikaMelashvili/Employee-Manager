package com.melashvili.employeemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {

    @Id
    @Column(name = "adminId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column(name = "adminFirstName")
    private String adminFirstName;

    @Column(name = "adminLastName")
    private String adminLastName;

    @Column(name = "adminEmail")
    private String adminEmail;

    @Column(name = "adminPassword")
    private String adminPassword;
}
