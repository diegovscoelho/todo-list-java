package diegovscoelho.todo.services;

import diegovscoelho.todo.entities.Task;
import diegovscoelho.todo.entities.User;
import diegovscoelho.todo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public void deleteUser(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Task not found with id " + id);
        }
        repository.deleteById(id);
    }
}
