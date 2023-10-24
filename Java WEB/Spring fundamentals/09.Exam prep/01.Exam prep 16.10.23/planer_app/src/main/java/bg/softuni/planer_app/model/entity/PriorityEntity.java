package bg.softuni.planer_app.model.entity;

import bg.softuni.planer_app.model.enums.PriorityNameEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "priorities")
public class PriorityEntity extends BaseEntity{

    //•	Has a Priority name (unique, not null)
    //  o	an option between (URGENT, IMPORTANT, LOW)
    //•	Has a Description  (not null)
    //  o	For URGENT - "An urgent problem that blocks the system use until the issue is resolved."
    //  o	For IMPORTANT – "A core functionality that your product is explicitly supposed to perform is compromised."
    //  o	For LOW – "Should be fixed if time permits but can be postponed."
    //•	Has collection of Tasks
    //  o	One priority may have many tasks, but one task has only one priority.

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private PriorityNameEnum name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority")
    private Set<TaskEntity> tasks;

    public PriorityEntity() {
    }

    private void setDescription(PriorityNameEnum name){
        String description = "";

        switch (name){
            case URGENT -> description = "An urgent problem that blocks the system use until the issue is resolved.";
            case IMPORTANT -> description = "A core functionality that your product is explicitly supposed to perform is compromised.";
            case LOW -> description = "Should be fixed if time permits but can be postponed.";
        }
        this.description = description;
    }

    public PriorityNameEnum getName() {
        return name;
    }

    public void setName(PriorityNameEnum name) {
        this.name = name;
        setDescription(name); //the custom setter!
    }

    public String getDescription() {
        return description;
    }

    public PriorityEntity setDescription(String description) {

        this.description = description;
        return this;
    }

    public Set<TaskEntity> getTasks() {
        return tasks;
    }

    public PriorityEntity setTasks(Set<TaskEntity> tasks) {
        this.tasks = tasks;
        return this;
    }
}
