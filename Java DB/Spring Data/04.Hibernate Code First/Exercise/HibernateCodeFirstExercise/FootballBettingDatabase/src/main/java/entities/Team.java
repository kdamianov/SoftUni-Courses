package entities;

import entities.enums.TeamInitial;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
    @Column
    private String name;
    @Column
    private String logo;
    @Column
    @Enumerated(EnumType.STRING)
    private TeamInitial initial;
    private Color primaryColor;
    private Town homeTown;
    private BigDecimal budget;
}
