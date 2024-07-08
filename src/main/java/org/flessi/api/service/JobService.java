package org.flessi.api.service;

import lombok.AllArgsConstructor;
import org.flessi.api.model.dto.request.CreateJobRequest;
import org.flessi.api.model.entity.Job;
import org.flessi.api.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JobService {
    private JobRepository jobRepository;

    public String createJobOffer(CreateJobRequest request){
        Job jobOffer = jobRepository.save(
                Job.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .image(request.getImage())
                        .startTime(request.getStartTime())
                        .endTime(request.getEndTime())
                        .companyID(request.getCompanyID())
                        .address(request.getAddress())
                        .city(request.getCity())
                        .amountToPay(request.getAmountToPay())
                        .amountPerHour(request.getAmountPerHour())
                        .category(request.getCategory())
                        .requirements(request.getRequirements())
                        .build()
        );

        return jobOffer.getId();
    }

    public List<Job> fetchAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> fetchJobsByIds(List<String> ids) {
        List<Job> jobs = new ArrayList<>();
        jobRepository.findAllById(ids).forEach(jobs::add);
        return jobs;
    }
}
