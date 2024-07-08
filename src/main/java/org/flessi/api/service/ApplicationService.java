package org.flessi.api.service;

import lombok.AllArgsConstructor;
import org.flessi.api.model.dto.request.CreateApplicationRequest;
import org.flessi.api.model.entity.Application;
import org.flessi.api.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ApplicationService {
    private ApplicationRepository applicationRepository;

    public String applyToJob(CreateApplicationRequest request){
        Application application = applicationRepository.save(
                Application.builder()
                        .workerId(request.getWorkerId())
                        .jobId(request.getJobId())
                        .build()
        );

        return application.getId();
    }

    public List<String> fetchApplicationIds(String userID) {
        return applicationRepository.findByWorkerId(userID)
                .stream()
                .map(Application::getJobId)
                .collect(toList());
    }
}
