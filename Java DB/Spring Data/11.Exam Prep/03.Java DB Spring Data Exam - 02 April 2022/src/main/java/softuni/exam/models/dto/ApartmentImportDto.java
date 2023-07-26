package softuni.exam.models.dto;

import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Town;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentImportDto {
    //•	Constraint: The apartment table has а relation with the towns table.
    @XmlElement()
    @NotNull
    private ApartmentType apartmentType;
    @XmlElement()
    @DecimalMin(value = "40.00")
    @NotNull
    private Double area;
    @ManyToOne
    @NotNull
    private String town;

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
