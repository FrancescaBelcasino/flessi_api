package org.flessi.api.controller;

import lombok.AllArgsConstructor;
import org.flessi.api.model.dto.request.CreateCompanyRequest;
import org.flessi.api.model.dto.request.CreateJobRequest;
import org.flessi.api.model.dto.request.CreateWorkerRequest;
import org.flessi.api.model.dto.response.IdResponse;
import org.flessi.api.service.JobService;
import org.flessi.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {
    private UserService service;
    private JobService jobService;

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

    @PostMapping("/jobs/create-offer")
    public ResponseEntity<IdResponse> createJobOffer(@RequestBody CreateJobRequest request) {
        var id = jobService.createJobOffer(request);

        return ResponseEntity.ok(new IdResponse(id));
    }
}
