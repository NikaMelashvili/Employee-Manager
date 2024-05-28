package com.melashvili.employeemanager.repository;

import com.melashvili.employeemanager.model.lib.TaskImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskImageRepository extends CrudRepository<TaskImage, Long> {
}
