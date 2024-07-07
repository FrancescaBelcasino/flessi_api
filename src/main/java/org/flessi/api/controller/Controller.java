package org.flessi.api.controller;

import lombok.AllArgsConstructor;
import org.flessi.api.model.dto.request.*;
import org.flessi.api.model.dto.response.IdResponse;
import org.flessi.api.model.dto.response.ResultsResponse;
import org.flessi.api.model.entity.Job;
import org.flessi.api.service.ApplicationService;
import org.flessi.api.service.JobService;
import org.flessi.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", methods = {GET, POST})
public class Controller {
    private UserService service;
    private JobService jobService;
    private ApplicationService applicationService;

    @PostMapping("/users/register-worker")
    public ResponseEntity<IdResponse> registerWorker(@RequestBody CreateWorkerRequest request) {
        String id = service.createWorker(request);

        return ResponseEntity.ok(new IdResponse(id));
    }

    @PostMapping("/users/register-company")
    public ResponseEntity<IdResponse> registerCompany(@RequestBody CreateCompanyRequest request) {
        String id = service.createCompany(request);

        return ResponseEntity.ok(new IdResponse(id));
    }

    @PostMapping("/users/login")
    public ResponseEntity<IdResponse> genericLogin(@RequestBody LoginRequest request) {
        String userID = service.genericLogin(request);

        return userID != null ?
                ResponseEntity.ok(new IdResponse(userID)) :
                ResponseEntity.badRequest().build();
    }

    @PostMapping("/jobs/create-offer")
    public ResponseEntity<IdResponse> createJobOffer(@RequestBody CreateJobRequest request) {
        String id = jobService.createJobOffer(request);

        return ResponseEntity.ok(new IdResponse(id));
    }

    @PostMapping("/jobs/apply")
    public ResponseEntity<IdResponse> applyToJob(@RequestBody CreateApplicationRequest request) {
        String id = applicationService.applyToJob(request);

        return ResponseEntity.ok(new IdResponse(id));
    }

    @GetMapping("/jobs")
    public ResponseEntity<ResultsResponse> fetchAllJobs() {
        List<Job> jobs = jobService.fetchAllJobs();

        return ResponseEntity.ok(new ResultsResponse(jobs));
    }

}
