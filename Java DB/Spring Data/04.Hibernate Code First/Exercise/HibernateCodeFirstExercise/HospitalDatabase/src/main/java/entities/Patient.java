package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient extends BaseEntity{
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;
    @Column(nullable = false)
    private String address;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Basic
    private String picture;
    @Column(name = "has_medical_insurance")
    private boolean hasMedicalInsurance;
    @OneToMany(targetEntity = Visitation.class, mappedBy = "patient")
    private Set<Visitation> visitations;
}
