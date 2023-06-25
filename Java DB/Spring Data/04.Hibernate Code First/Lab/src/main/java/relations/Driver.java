package relations;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;
    @ManyToMany(targetEntity = RelationTruck.class,
            mappedBy = "drivers")
    private List<RelationTruck> trucks;

    public Driver() {
    }

    public Driver(String fullName) {
        this.fullName = fullName;
        this.trucks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
