package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String comments;
    @OneToMany(targetEntity = Visitation.class, mappedBy = "diagnose")
    private Set<Visitation> visitationSet;
}
