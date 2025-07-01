package diegovscoelho.todo.services;

import diegovscoelho.todo.entities.Task;
import diegovscoelho.todo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    public Task updateTask(Long id, Task taskDetails) {
        return repository.findById(id).map(existingTask -> {
            existingTask.setTitle(taskDetails.getTitle());
            existingTask.setDescription(taskDetails.getDescription());
            existingTask.setCompleted(taskDetails.isCompleted());

            return repository.save(existingTask);
        }).orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    public void deleteTask(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Task not found with id " + id);
        }
        repository.deleteById(id);
    }
}