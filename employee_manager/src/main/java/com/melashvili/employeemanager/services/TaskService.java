package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.dto.TaskDTO;
import com.melashvili.employeemanager.model.lib.Task;
import com.melashvili.employeemanager.model.lib.TaskImage;
import com.melashvili.employeemanager.model.mapper.TaskMapper;
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

    public List<TaskDTO> getAllTasks() {
        Iterable<Task> temp = taskRepository.findAll();
        List<Task> tasks = new ArrayList<>();
        for (Task task : temp) {
            tasks.add(task);
            System.out.println(task.toString());
        }
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for (Task task : tasks) {
            taskDTOS.add(TaskMapper.taskToDto(task));
        }
        return taskDTOS;
    }

    public TaskDTO getTaskById(Long id) {
        return TaskMapper.taskToDto(taskRepository.findById(id).get());
    }

    public void saveTask(TaskDTO userTask, MultipartFile file) throws IOException {
        Task task = new Task();
        TaskImage taskImage = new TaskImage();
        taskImage.setImageName(file.getOriginalFilename());
        taskImage.setImageData(file.getBytes());
        task.setTaskImage(taskImage);
        task.setAdmin(userTask.getAdmin());
        task.setEmployee(userTask.getEmployee());
        task.setTaskName(userTask.getTaskName());
        task.setTaskDescription(userTask.getTaskDescription());
        taskRepository.save(task);
    }

    public void updateTaskById(Long id, TaskDTO updatedTask, MultipartFile file) throws IOException {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            TaskImage taskImage = new TaskImage();
            taskImage.setImageName(file.getOriginalFilename());
            taskImage.setImageData(file.getBytes());

            task.setAdmin(updatedTask.getAdmin());
            task.setEmployee(updatedTask.getEmployee());
            task.setTaskName(updatedTask.getTaskName());
            task.setTaskDescription(updatedTask.getTaskDescription());
            task.setTaskImage(taskImage);

            taskRepository.save(task);
        } else {
            System.out.println("Task not found");
        }
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
