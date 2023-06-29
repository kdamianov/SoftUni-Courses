package entites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher extends User {
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "salary_per_hour")
    private Float salaryPerHour;
    @OneToMany(targetEntity = Course.class, mappedBy = "teacher")
    private Set<Course> courses;
}
