package relations;

import javax.persistence.*;

@Entity
@Table(name = "relations_car")
public class RelationsCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column
    private String model;
    @Column
    private double price;
    @Column
    private String type;
    @Column
    private int seats;
    @OneToOne()
    @JoinColumn(name = "plate_id")
    private PlateNumber plateNumber;

    public RelationsCar(String fuelType, String model, double price, String type, int seats) {
        this.fuelType = fuelType;
        this.model = model;
        this.price = price;
        this.type = type;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public PlateNumber getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }
}
