package relations;

import javax.persistence.*;

@Entity
@Table(name = "plate_numbers")
public class PlateNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String number;
//    @OneToOne(targetEntity = RelationsCar.class, //указваме, че връзката вече съществува,
//    mappedBy = "plateNumber")                    //иначе ще се създаде нова такава с нова колона,
//    private RelationsCar relationsCar;           //ако не се посочи --> Unidirectional

    public PlateNumber() {

    }
    public PlateNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
