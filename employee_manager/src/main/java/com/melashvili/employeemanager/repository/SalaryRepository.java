package com.melashvili.employeemanager.repository;

import com.melashvili.employeemanager.model.lib.Salary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends CrudRepository<Salary, Long> {
}
