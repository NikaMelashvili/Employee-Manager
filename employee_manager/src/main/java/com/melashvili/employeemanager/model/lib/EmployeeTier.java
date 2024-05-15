package com.melashvili.employeemanager.model.lib;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employee_tier")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class EmployeeTier {

    @Id
    @Column(name = "tier_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tierId;

    @Column(name = "tier_name")
    private String tierName;

    @Column(name = "tier_description")
    private String tierDescription;
}
