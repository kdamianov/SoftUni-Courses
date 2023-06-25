package relations;

import javax.persistence.*;

@Entity
@Table(name = "planes")
public class RelationsPlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column
    private String model;
    @Column
    private double price;
    @Column
    private String type;
    @Column
    private String airline;
    @Column(name = "passenger_capacity")
    private int passengerCapacity;
    @ManyToOne
    @JoinColumn(name = "company_id",      //как да се казва колоната
            referencedColumnName = "id")  //името на коя колона в другата таблица да реферира
    private Company company;

    public RelationsPlane() {
    }

    public RelationsPlane(String fuelType, String model, double price,
                          String type, String airline, int passengerCapacity) {
        this.fuelType = fuelType;
        this.model = model;
        this.price = price;
        this.type = type;
        this.airline = airline;
        this.passengerCapacity = passengerCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
