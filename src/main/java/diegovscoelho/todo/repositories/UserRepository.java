package diegovscoelho.todo.repositories;

import diegovscoelho.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
