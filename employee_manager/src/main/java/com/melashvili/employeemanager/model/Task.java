package com.melashvili.employeemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {

    @Id
    @Column(name = "taskId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adminId")
    private Admin admin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employeeId")
    private List<Employee> employee;

    @Column(name = "taskName")
    private String taskName;

    @Column(name = "taskDescription")
    private String taskDescription;

    @Column(name = "taskFile")
    private byte[] taskFile;
}
