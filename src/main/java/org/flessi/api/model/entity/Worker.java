package org.flessi.api.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document(collection = "users")
public class Worker {
    @Id
    private String id;
    private String type;
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private Integer cantRatings;
    private Integer sumRatings;

}
