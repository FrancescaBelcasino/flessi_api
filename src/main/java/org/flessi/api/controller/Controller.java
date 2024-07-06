package org.flessi.api.controller;

import lombok.AllArgsConstructor;
import org.flessi.api.model.dto.request.*;
import org.flessi.api.model.dto.response.IdResponse;
import org.flessi.api.model.dto.response.ResultResponse;
import org.flessi.api.model.dto.response.ResultsResponse;
import org.flessi.api.service.ApplicationService;
import org.flessi.api.service.JobService;
import org.flessi.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {
    private UserService service;
    private JobService jobService;
    private ApplicationService applicationService;

    @PostMapping("/users/register-worker")
    public ResponseEntity<IdResponse> registerWorker(@RequestBody CreateWorkerRequest request) {
        var id = service.createWorker(request);

        return ResponseEntity.ok(new IdResponse(id));
    }

    @PostMapping("/users/register-company")
    public ResponseEntity<IdResponse> registerCompany(@RequestBody CreateCompanyRequest request) {
        var id = service.createCompany(request);

        return ResponseEntity.ok(new IdResponse(id));
    }

    @PostMapping("/users/login-worker")
    public ResponseEntity<?> genericLogin(@RequestBody LoginRequest request) {
        var loggedIn = service.genericLogin(request);

        return loggedIn ?
                ResponseEntity.ok(new ResultResponse(true)) :
                ResponseEntity.badRequest().build();
    }

    @PostMapping("/jobs/create-offer")
    public ResponseEntity<IdResponse> createJobOffer(@RequestBody CreateJobRequest request) {
        var id = jobService.createJobOffer(request);

        return ResponseEntity.ok(new IdResponse(id));
    }

    @PostMapping("/jobs/apply")
    public ResponseEntity<IdResponse> applyToJob(@RequestBody CreateApplicationRequest request) {
        var id = applicationService.applyToJob(request);

        return ResponseEntity.ok(new IdResponse(id));
    }

    @GetMapping("/jobs/all-jobs")
    public ResponseEntity<ResultsResponse> fetchAllJobs() {
        var jobs = jobService.fetchAllJobs();

        return ResponseEntity.ok(new ResultsResponse(jobs));
    }

}
