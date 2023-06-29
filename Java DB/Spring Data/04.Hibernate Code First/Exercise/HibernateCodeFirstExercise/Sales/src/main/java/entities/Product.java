package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "price")
    private BigDecimal price;
    @OneToMany(mappedBy = "product")
    private Set<Sale> sales;

}
