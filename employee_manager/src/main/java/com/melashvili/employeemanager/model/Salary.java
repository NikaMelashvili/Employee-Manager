package com.melashvili.employeemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salary")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Salary {
    @Id
    @Column(name = "sId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @Column(name = "grossSalary")
    private Long grossSalary;

    @Column(name = "netSalary")
    private Long netSalary;
}
