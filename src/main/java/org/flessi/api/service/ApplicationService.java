package org.flessi.api.service;

import lombok.AllArgsConstructor;
import org.flessi.api.model.dto.request.CreateApplicationRequest;
import org.flessi.api.model.entity.Application;
import org.flessi.api.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationService {
    private ApplicationRepository applicationRepository;

    public String applyToJob (CreateApplicationRequest request){
        var application = applicationRepository.save(
                Application.builder()
                        .workerId(request.getWorkerId())
                        .jobId(request.getJobId())
                        .build()
        );

        return application.getId();
    }
}
