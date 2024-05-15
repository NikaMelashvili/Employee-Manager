package com.melashvili.employeemanager.repository;

import com.melashvili.employeemanager.model.lib.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
