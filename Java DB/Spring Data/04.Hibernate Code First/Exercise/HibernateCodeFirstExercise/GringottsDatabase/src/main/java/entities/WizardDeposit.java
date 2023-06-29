package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit {

    @Id
    private Long id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "magic_wand_creator", length = 100)
    private String magicWandCreator;
    @Column(name = "magic_wand_size")
    private Short magicWandSize;
    @Column(name = "deposit_group", length = 20)
    private String depositGroup;
    @Column(name = "deposit_start_date")
    private Date depositStartDate;
    @Column(name = "deposit_amount", precision = 10, scale = 3) // --> (DECIMAL 10, 3)
    private BigDecimal depositAmount;
    @Column(name = "deposit_interest", precision = 4, scale = 2)
    private Float depositInterest;
    @Column(name = "deposit_charge", precision = 10, scale = 2)
    private Float depositCharge;
    @Column(name = "deposit_expiration_date")
    private Date depositExpirationDate;
    @Column(name = "is_deposit_expired")
    private boolean isDepositExpired;

    public WizardDeposit() {
    }


}
