package org.flessi.api.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Builder
@Document("jobs")
public class Job {
    @Id
    private String id;
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
