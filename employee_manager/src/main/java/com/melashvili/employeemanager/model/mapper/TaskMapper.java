package com.melashvili.employeemanager.model.mapper;

import com.melashvili.employeemanager.model.dto.TaskDTO;
import com.melashvili.employeemanager.model.lib.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public static Task dtoToTask(TaskDTO dto) {
        Task task = new Task();

        task.setTaskName(dto.getTaskName());
        task.setTaskDescription(dto.getTaskDescription());
        task.setAdmin(dto.getAdmin());
        task.setEmployee(dto.getEmployee());

        return task;
    }

    public static TaskDTO taskToDto(Task task) {
        TaskDTO dto = new TaskDTO();

        dto.setTaskName(task.getTaskName());
        dto.setTaskDescription(task.getTaskDescription());
        dto.setAdmin(task.getAdmin());
        dto.setEmployee(task.getEmployee());

        return dto;
    }
}
