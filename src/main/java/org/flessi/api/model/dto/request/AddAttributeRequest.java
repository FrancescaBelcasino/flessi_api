package org.flessi.api.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddAttributeRequest {
    private String type;
    private String value;
}
