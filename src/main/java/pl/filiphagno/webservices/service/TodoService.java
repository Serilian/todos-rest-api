package pl.filiphagno.webservices.service;

import org.springframework.stereotype.Service;
import pl.filiphagno.webservices.domain.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> todoList;
    private static Long counter = 1l;

    public TodoService() {
        this.todoList = new ArrayList<>();
        todoList.add(new Todo(counter++, "Learn Java", new Date(), false, "fhagno"));
        todoList.add(new Todo(counter++, "Learn Java some more", new Date(), false, "fhagno"));
        todoList.add(new Todo(counter++, "Learn Dev ops", new Date(), false, "fhagno"));
        todoList.add(new Todo(counter++, "Learn something", new Date(), false, "fhagnos"));
        todoList.add(new Todo(counter++, "Learn nothing", new Date(), false, "fhagno"));
    }


    public List<Todo> getTodosForUser(String username) {
        List<Todo> result = new ArrayList<>();
        todoList.forEach(todo -> {
            if (todo.getUserName().equalsIgnoreCase(username)) {
                result.add(todo);
            }
        });
        return result;
    }

    public String removeTodo(long id, String user) {
        for (Todo todo : todoList) {
            if (todo.getId() == id && todo.getUserName().equalsIgnoreCase(user)) {
                todoList.remove(todo);
                return "todo removed";
            }
        }
        return "todo with id " + id + "for user: " + user + "not found ";
    }

    public Todo getTodoById(String user, long id) {
        for (Todo todo : todoList) {
            if (todo.getId() == id && todo.getUserName().equalsIgnoreCase(user)) {
                return todo;
            }
        }
        return null;
    }

    public Todo saveOrUpdateTodo(Todo newOrUpdatedTodo) {
        if (newOrUpdatedTodo.getId() <= 0 ) {
            newOrUpdatedTodo.setId(counter++);
            todoList.add(newOrUpdatedTodo);
        } else {

            Todo todo = findById(newOrUpdatedTodo.getId());
            todoList.remove(todo);
            todoList.add(newOrUpdatedTodo);
        }
        return newOrUpdatedTodo;
    }


    public Todo findById(long id) {
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
