package com.example.xmlprocessingexercise.model.dto.users;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWrapperDto {
    @XmlAttribute(name = "count")
    private Integer count;
    @XmlElement(name = "user")
    private List<UsersWithProductsDto> users;

    public UserWrapperDto(List<UsersWithProductsDto> users) {
        this.users = users;
        this.count = users.size();
    }
}
