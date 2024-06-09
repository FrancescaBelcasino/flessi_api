package org.flessi.api.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.flessi.api.model.enums.Category;
import org.flessi.api.model.enums.Requirement;
import org.flessi.api.model.enums.Skill;

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
    private Category category;
    private List<Skill> skills;
    private List<Requirement> requirements;
}
