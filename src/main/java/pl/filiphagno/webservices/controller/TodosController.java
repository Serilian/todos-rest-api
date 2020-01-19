package pl.filiphagno.webservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filiphagno.webservices.domain.Todo;
import pl.filiphagno.webservices.service.TodoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class TodosController {

    private TodoService todoService;

    @Autowired
    public TodosController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{user}/todos")
    public List<Todo> getAllTodosForUser(@PathVariable String user) {
        return todoService.getTodosForUser(user);
    }

    @DeleteMapping("/{user}/todos/{id}")
    public String removeTodobyId(@PathVariable long id, @PathVariable String user) {
        return todoService.removeTodo(id, user);
    }

    @GetMapping("/{user}/todos/{id}")
    public Todo getTodoByUserAndId(@PathVariable String user, @PathVariable long id) {
        return todoService.getTodoById(user, id);
    }

    @PutMapping("/{user}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String user, @PathVariable long id, @RequestBody Todo todo) {
        Todo updatedTodo =  todoService.saveOrUpdateTodo(todo);
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping("/{user}/todos")
    public ResponseEntity<Todo> addTodo(@PathVariable String user, @RequestBody Todo todo) {
        Todo newTodo = todoService.saveOrUpdateTodo(todo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }
}
