package com.example.xmlprocessingexercise.model.dto.users;

import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedDto {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    @Size(min = 3)
    private String lastName;
    @XmlAttribute(name = "age")
    private Integer age;


}
