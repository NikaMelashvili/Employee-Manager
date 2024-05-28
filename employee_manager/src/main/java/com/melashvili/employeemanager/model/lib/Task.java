package com.melashvili.employeemanager.model.lib;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_id")
    private List<Employee> employee;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;

    @OneToOne(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @JoinColumn(name = "task_file")
    private TaskImage taskImage;
}
