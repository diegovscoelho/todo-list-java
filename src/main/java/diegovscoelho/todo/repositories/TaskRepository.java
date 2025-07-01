package diegovscoelho.todo.repositories;

import diegovscoelho.todo.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
