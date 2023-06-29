package entities;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetail {
    @Id  //assume that every number should be unique, like an ID
    @Column(unique = true)
    private String number;
    @ManyToOne
    private User owner;
}
