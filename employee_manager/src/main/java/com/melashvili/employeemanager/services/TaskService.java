package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.lib.Task;
import com.melashvili.employeemanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        Iterable<Task> temp = taskRepository.findAll();
        List<Task> tasks = new ArrayList<>();
        for (Task task : temp) {
            tasks.add(task);
            System.out.println(task.toString());
        }
        return tasks;
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public void saveTask(Task task, MultipartFile file) throws IOException {
        taskRepository.save(task);
    }

    public void updateTaskById(Long id, Task updatedTask) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();

            task.setTaskName(updatedTask.getTaskName());
            task.setTaskDescription(updatedTask.getTaskDescription());
            task.setEmployee(updatedTask.getEmployee());
            task.setAdmin(updatedTask.getAdmin());
            task.setTaskFile(updatedTask.getTaskFile());

            taskRepository.save(task);
        } else {
            System.out.println("Task not found");
        }
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
