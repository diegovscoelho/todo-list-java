package diegovscoelho.todo.controllers;

import diegovscoelho.todo.entities.Task;
import diegovscoelho.todo.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = service.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = service.getTaskById(id);
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task updatedTask = service.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }
}
