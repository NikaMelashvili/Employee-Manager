package com.melashvili.employeemanager.controllers;

import com.melashvili.employeemanager.model.dto.TaskDTO;
import com.melashvili.employeemanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/get/task")
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        List<TaskDTO> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/get/task/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id){
        TaskDTO task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    // under construction ...
//    @PostMapping("/post/task")
//    public void saveTask(@RequestBody Task task) {
//
//        MultipartFile multipartFile = task.getTaskFile();
//
//        taskService.saveTask(task);
//    }

    @PutMapping("/put/task/{id}")
    public ResponseEntity<Void> updateTask (@PathVariable Long id,
                                            @RequestBody TaskDTO task) {
        taskService.updateTaskById(id, task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
