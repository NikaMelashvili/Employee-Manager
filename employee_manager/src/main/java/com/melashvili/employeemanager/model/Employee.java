package com.melashvili.employeemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    @Column(name = "employeeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "employeeFirstName")
    private String employeeFirstName;

    @Column(name = "employeeLastName")
    private String employeeLastName;

    private Admin admin;

    private Sector sector;

    private EmployeeTier tier;
}
