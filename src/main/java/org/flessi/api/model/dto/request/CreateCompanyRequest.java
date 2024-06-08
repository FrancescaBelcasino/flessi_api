package org.flessi.api.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCompanyRequest {
    private String name;
    private String cuit;
    private String representativeName;
    private String representativeSurname;
    private String email;
    private String password;
    private String address;
    private String city;
    private String postalCode;
    private Integer cantRatings;
    private Integer sumRatings;
}
