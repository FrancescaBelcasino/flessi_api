package org.flessi.api.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateJobRequest {
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String companyID;
    private String address;
    private String city;
    private String postalCode;
    private Float amountToPay;
    private Float amountPerHour;
    private String category;
    private List<String> requirements;
}
