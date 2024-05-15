package com.melashvili.employeemanager.repository;

import com.melashvili.employeemanager.model.lib.EmployeeTier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTierRepository extends CrudRepository<EmployeeTier, Long> {
}
