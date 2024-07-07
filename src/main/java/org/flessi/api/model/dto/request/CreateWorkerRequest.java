package org.flessi.api.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateWorkerRequest {
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
}
