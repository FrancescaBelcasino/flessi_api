package org.flessi.api.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
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
    private LocalTime startTime;
    private LocalTime endTime;
    private String address;
    private String city;
    private Float amountToPay;
    private Float amountPerHour;
    private List<String> requirements;
}
