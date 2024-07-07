package org.flessi.api.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String category;
    private String image;
    private LocalTime startTime;
    private LocalTime endTime;
    private String address;
    private String city;
    private Float amountToPay;
    private Float amountPerHour;
    private List<String> requirements;

    private String companyID;
}
