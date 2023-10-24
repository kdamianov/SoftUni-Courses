package bg.softuni.planer_app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {
    //•	Has a Description (not null)
    //      o	Description length must be between 2 and 50 characters (inclusive of 2 and 50).
    //•	Has a dueDate (not null) - date
    //      o	The dueDate must be a positive in the future.
    //•	Has a Priority (not null)
    //      o	One task has one priority and one priority can have many tasks.
    //•	Has a User
    //      o	The user who has assigned the task to him, so he can work on the task.
    //      One task has one user, but one user may have many tasks.

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String description;

    @Column(nullable = false)
    @Future
    private LocalDate dueDate;

    @ManyToOne
    @NotNull
    private PriorityEntity priority;

    @ManyToOne
    private UserEntity assignee;


    public TaskEntity() {
    }

    public String getDescription() {
        return description;
    }

    public TaskEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskEntity setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityEntity getPriority() {
        return priority;
    }

    public TaskEntity setPriority(PriorityEntity priority) {
        this.priority = priority;
        return this;
    }

    public UserEntity getUser() {
        return assignee;
    }

    public TaskEntity setUser(UserEntity user) {
        this.assignee = user;
        return this;
    }
}
