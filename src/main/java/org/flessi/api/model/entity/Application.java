package org.flessi.api.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document("applications")
public class Application {
    @Id
    private String id;
    private String workerId;
    private String jobId;
}
