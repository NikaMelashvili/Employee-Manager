package com.melashvili.employeemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Admin admin;

    private Employee employee;

    @Column(name = "taskName")
    private String taskName;

    @Column(name = "taskDescription")
    private String taskDescription;

    @Column(name = "taskFile")
    private byte[] taskFile;
}
