package pl.filiphagno.webservices.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private Date deadline;
    private boolean isCompleted;
    private String userName;

    public Todo(long id, String description, Date deadline, boolean isCompleted, String userName) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.isCompleted = isCompleted;
        this.userName = userName;
    }

    public Todo() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
