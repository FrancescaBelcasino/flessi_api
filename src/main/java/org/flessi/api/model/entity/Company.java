package org.flessi.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder(toBuilder = true)
@Document(collection = "users")
public class Company implements Serializable {
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
    private Integer sumRatings;

    private transient List<Job> offers;

    @JsonIgnore
    private Integer cantRatings;
}
