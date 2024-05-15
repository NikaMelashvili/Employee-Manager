package com.melashvili.employeemanager.repository;

import com.melashvili.employeemanager.model.lib.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
