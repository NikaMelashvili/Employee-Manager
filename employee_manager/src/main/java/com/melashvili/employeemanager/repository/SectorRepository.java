package com.melashvili.employeemanager.repository;

import com.melashvili.employeemanager.model.Sector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends CrudRepository<Sector, Long> {
}
