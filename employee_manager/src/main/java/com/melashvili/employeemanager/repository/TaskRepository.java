package com.melashvili.employeemanager.repository;

import com.melashvili.employeemanager.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
