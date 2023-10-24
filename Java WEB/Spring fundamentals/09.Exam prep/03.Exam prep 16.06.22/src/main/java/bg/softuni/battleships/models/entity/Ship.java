package bg.softuni.battleships.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity {
    //•	Name
    //  o	The length of the values must be between 2 and 10 characters (both numbers are INCLUSIVE)
    //  o	The values should be unique in the database
    //
    //•	Health
    //  o	The values should be positive numbers
    //•	Power
    //  o	The values should be positive numbers
    //•	Created
    //  o	The values should not be future dates
    //•	Category
    //  o	A relationship with the Categories Entity
    //•	User
    //  o	A user that owns the ship
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private Long health;
    @Column(nullable = false)
    private Long power;
    @Column(nullable = false)
    private LocalDate created;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;

    public Ship() {
    }

    public String getName() {
        return name;
    }

    public Ship setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public Ship setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public Ship setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Ship setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Ship setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Ship setUser(User user) {
        this.user = user;
        return this;
    }
}
