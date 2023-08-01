package softuni.exam.models.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerImportDto {
    //•	first name - accepts char sequence (between 2 to 30 inclusive).
    //•	last name - accepts char sequence (between 2 to 30 inclusive).
    //•	salary - accepts number values that are more than or equal to 15000.00.
    //•	averageObservationHours - accepts number values that are more than 500.00.
    //•	birthday - a date in the "yyyy-MM-dd" format. Can be nullable.
    //•	observing star - the current star that the astronomer is studying.
    //•	Constraint: The astronomers table has a relation with stars table.

    @XmlElement(name = "average_observation_hours")
    @DecimalMin(value = "500.00")
    private Double averageObservationHours;
    @XmlElement
    private String birthday;
    @XmlElement(name = "first_name")
    @Size(min = 2, max = 30)
    private String firstName;
    @XmlElement(name = "last_name")
    @Size(min = 2, max = 30)
    private String lastName;
    @XmlElement
    @DecimalMin(value = "15000.00")
    private Double salary;
    @XmlElement(name = "observing_star_id")
    @NotNull
    private Long observingStarId;

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getObservingStarId() {
        return observingStarId;
    }

    public void setObservingStarId(Long observingStarId) {
        this.observingStarId = observingStarId;
    }
}
