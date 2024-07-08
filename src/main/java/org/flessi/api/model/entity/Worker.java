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
public class Worker implements Serializable {
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
    private Integer sumRatings;

    private List<String> interests;
    private List<String> skills;
    private List<String> experiences;

    private transient List<Job> applications;

    @JsonIgnore
    private Integer cantRatings;
}
