package org.flessi.api.service;

import lombok.AllArgsConstructor;
import org.flessi.api.model.dto.request.CreateJobRequest;
import org.flessi.api.model.entity.Job;
import org.flessi.api.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobService {
    private JobRepository jobRepository;

    public String createJobOffer(CreateJobRequest request){
        var jobOffer = jobRepository.save(
                Job.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .date(request.getDate())
                        .startTime(request.getStartTime())
                        .endTime(request.getEndTime())
                        .companyID(request.getCompanyID())
                        .address(request.getAddress())
                        .city(request.getCity())
                        .postalCode(request.getPostalCode())
                        .amountToPay(request.getAmountToPay())
                        .category(request.getCategory().name())
                        .skills(request.getSkills().stream()
                                .map(Enum::name)
                                .toList())
                        .requirements(request.getRequirements().stream().
                                map(Enum::name)
                                .toList())
                        .build()
        );

        return jobOffer.getId();
    }
}
