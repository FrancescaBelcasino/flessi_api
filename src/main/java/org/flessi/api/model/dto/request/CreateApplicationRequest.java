package org.flessi.api.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateApplicationRequest {
    private String workerId;
    private String jobId;
}
