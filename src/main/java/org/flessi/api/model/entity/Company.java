package org.flessi.api.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document(collection = "users")
public class Company {
    @Id
    private String id;
    private String type;
    private String name;
    private String cuit;
    private String representativeName;
    private String representativeSurname;
    private String email;
    private String password;
    private String address;
    private String city;
    private Integer cantRatings;
    private Integer sumRatings;
}
