package bg.softuni.planer_app.model.dto;

import bg.softuni.planer_app.model.entity.PriorityEntity;
import bg.softuni.planer_app.model.enums.PriorityNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskAddBindingModel {
    @NotNull
    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters")
    private String description;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Due Date must be in the future!")
    private LocalDate dueDate;

    @NotNull(message = "You must select a priority!")
    private PriorityNameEnum priority;

    public TaskAddBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityNameEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityNameEnum priority) {
        this.priority = priority;
    }
}
