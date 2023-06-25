package relations;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany(targetEntity = RelationsPlane.class,  //указваме, че вързката е една и към кой клас сочи
    mappedBy = "company",                   //указваме, коя колона свързва
    fetch = FetchType.EAGER,                //указва кога да бъде генерирана заявката (EAGER or LAZY)
    cascade = CascadeType.ALL)              //кои операции да бъдат прехвърлени към свързаните entities
    private List<RelationsPlane> relationsPlanes;             //трябва да е колекция от обектите, които реферира
    public Company() {
    }
    public Company(String name) {
        this.name = name;
        this.relationsPlanes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RelationsPlane> getPlanes() {
        return relationsPlanes;
    }

    public void setPlanes(List<RelationsPlane> relationsPlanes) {
        this.relationsPlanes = relationsPlanes;
    }
}
