package pl.filiphagno.webservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.filiphagno.webservices.domain.Todo;
import pl.filiphagno.webservices.domain.TodoJPARepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/jpa/users")
public class TodosJPAController {

    private TodoJPARepository todoJPARepository;

    @Autowired
    public TodosJPAController(TodoJPARepository todoJPARepository) {
        this.todoJPARepository = todoJPARepository;
    }


    @GetMapping("/{user}/todos")
    public List<Todo> getAllTodosForUser(@PathVariable String user) {
        return todoJPARepository.findByUserName(user);
    }

    @DeleteMapping("/{user}/todos/{id}")
    public void removeTodobyId(@PathVariable long id, @PathVariable String user) {
        todoJPARepository.deleteById(id);
    }

    @GetMapping("/{user}/todos/{id}")
    public Todo getTodo(@PathVariable String user, @PathVariable long id) {
        return todoJPARepository.findById(id).get();
    }

    @PutMapping("/{user}/todos/{id}")
    public Todo updateTodo(@PathVariable String user, @PathVariable long id, @RequestBody Todo todo) {

        todo.setUserName(user);
        return todoJPARepository.save(todo);
    }

    @PostMapping("/{user}/todos")
    public Todo addTodo(@PathVariable String user, @RequestBody Todo todo) {

        todo.setUserName(user);

        return todoJPARepository.save(todo);
    }
}
