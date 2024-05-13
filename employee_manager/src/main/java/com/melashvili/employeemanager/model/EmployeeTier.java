package com.melashvili.employeemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employeeTier")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeTier {

    @Id
    @Column(name = "tierId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tierId;

    @Column(name = "tierName")
    private String tierName;

    @Column(name = "tierDescription")
    private String tierDescription;
}
