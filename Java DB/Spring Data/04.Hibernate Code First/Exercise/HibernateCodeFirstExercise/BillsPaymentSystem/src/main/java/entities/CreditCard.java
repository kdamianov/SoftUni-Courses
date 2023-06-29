package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail{
    //expiration month, expiration year
    @Column(name = "card_type", nullable = false)
    private String cardType;
    @Column(name = "expiration_month", nullable = false)
    private short expirationMonth;
    @Column(name = "expiration_year", nullable = false)
    private short expirationYear;
}
