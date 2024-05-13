package com.melashvili.employeemanager.repository;

import com.melashvili.employeemanager.model.Admin;
import com.melashvili.employeemanager.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
