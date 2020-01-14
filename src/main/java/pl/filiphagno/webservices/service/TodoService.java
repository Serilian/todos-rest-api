package pl.filiphagno.webservices.service;

import org.springframework.stereotype.Service;
import pl.filiphagno.webservices.domain.Todo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> todoList;

    public TodoService() {
        this.todoList = new ArrayList<>();
        todoList.add(new Todo(1, "Learn Java", new Date(), false, "fhagno"));
        todoList.add(new Todo(2, "Learn Java some more", new Date(), false, "fhagno"));
        todoList.add(new Todo(3, "Learn Dev ops", new Date(), false, "fhagno"));
        todoList.add(new Todo(4, "Learn something", new Date(), false, "fhagnos"));
        todoList.add(new Todo(5, "Learn nothing", new Date(), false, "fhagno"));
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
        for(Todo todo: todoList) {
            if(todo.getId() == id && todo.getUserName().equalsIgnoreCase(user))  {
                todoList.remove(todo);
                return "todo removed";
            }
        }
        return "todo with id " +id + "for user: " + user +"not found " ;
    }
}
