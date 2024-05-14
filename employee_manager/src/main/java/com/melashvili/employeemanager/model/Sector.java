package com.melashvili.employeemanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "sector")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Sector {
    @Id
    @Column(name = "sector_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectorId;

    @Column(name = "sector_name")
    private String sectorName;

    @Column(name = "sector_location")
    private String sectorLocation;
}
