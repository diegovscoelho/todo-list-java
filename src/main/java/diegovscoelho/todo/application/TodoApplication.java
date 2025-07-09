package diegovscoelho.todo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "diegovscoelho.todo.repositories")
@ComponentScan(basePackages = {"diegovscoelho.todo"})
@EntityScan(basePackages = "diegovscoelho.todo.entities")
public class TodoApplication {
    public static void main(String[] args) {

        SpringApplication.run(TodoApplication.class, args);
    }
}
