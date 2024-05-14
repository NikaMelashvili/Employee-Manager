package com.melashvili.employeemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "salary")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Salary {
    @Id
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "gross_salary")
    private Long grossSalary;

    @Column(name = "net_salary")
    private Long netSalary;
}
