package softuni.exam.models.dto;

import java.math.BigDecimal;
import java.util.Locale;

public class TaskExportDto {
    private Long id;
    private BigDecimal price;

    private MechanicExportInfoDto mechanic;

    private CarExportInfoDto car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MechanicExportInfoDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicExportInfoDto mechanic) {
        this.mechanic = mechanic;
    }

    public CarExportInfoDto getCar() {
        return car;
    }

    public void setCar(CarExportInfoDto car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"Car %s %s with %dkm\n" +
                "-Mechanic: %s %s - task №%d:\n" +
                " --Engine: %.1f\n" +
                "---Price: %s$\n",
                this.car.getCarMake(),
                this.car.getCarModel(),
                this.car.getKilometers(),
                this.mechanic.getFirstName(),
                this.mechanic.getLastName(),
                this.id,
                this.car.getEngine(),
                this.price.setScale(2));
    }
}
