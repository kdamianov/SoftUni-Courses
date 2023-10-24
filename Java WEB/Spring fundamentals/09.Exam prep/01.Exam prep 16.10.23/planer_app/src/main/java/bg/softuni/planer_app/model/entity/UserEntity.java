package bg.softuni.planer_app.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {


    @Column(unique = true, nullable = false)
    @Length(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @OneToMany(mappedBy = "assignee")
    private Set<TaskEntity> assignedTasks;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<TaskEntity> getAssignedTasks() {
        return assignedTasks;
    }

    public UserEntity setAssignedTasks(Set<TaskEntity> assignedTasks) {
        this.assignedTasks = assignedTasks;
        return this;
    }
}
