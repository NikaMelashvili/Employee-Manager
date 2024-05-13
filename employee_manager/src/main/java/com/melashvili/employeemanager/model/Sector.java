package com.melashvili.employeemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sector")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sector {
    @Id
    @Column(name = "sectorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectorId;

    @Column(name = "sectorName")
    private String sectorName;

    @Column(name = "sectorLocation")
    private String sectorLocation;
}
