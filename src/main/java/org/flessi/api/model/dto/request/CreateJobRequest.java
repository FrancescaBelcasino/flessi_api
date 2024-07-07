package org.flessi.api.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateJobRequest {
    private String companyID;
    private String title;
    private String description;
    private String category;
    private String image;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String address;
    private String city;
    private Float amountToPay;
    private Float amountPerHour;
    private List<String> requirements;
}
