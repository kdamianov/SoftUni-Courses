package softuni.exam.models.dto;

import softuni.exam.models.entity.Mechanic;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportDto {
    //•	price – accepts a very big positive number.
    //•	date – a date and time of registering the task in the "yyyy-MM-dd HH:mm:ss" format.
    //•	Constraint: The task table has a relation with the parts table.
    //•	Constraint: The task table has a relation with the mechanics table.
    //•	Constraint: The task table has a relation with the cars table.
    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;
    @XmlElement
    @NotNull
    private String date;
    @XmlElement
    @NotNull
    private CarBasic car;
    @XmlElement
    @NotNull
    private MechanicBasic mechanic;
    @XmlElement
    @NotNull
    private PartBasic part;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CarBasic getCar() {
        return car;
    }

    public void setCar(CarBasic car) {
        this.car = car;
    }

    public MechanicBasic getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicBasic mechanic) {
        this.mechanic = mechanic;
    }

    public PartBasic getPart() {
        return part;
    }

    public void setPart(PartBasic part) {
        this.part = part;
    }
}
