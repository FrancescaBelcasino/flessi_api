package org.flessi.api.service;

import lombok.AllArgsConstructor;
import org.flessi.api.model.dto.request.CreateCompanyRequest;
import org.flessi.api.model.dto.request.CreateWorkerRequest;
import org.flessi.api.model.entity.Company;
import org.flessi.api.model.entity.Worker;
import org.flessi.api.repository.CompanyRepository;
import org.flessi.api.repository.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private WorkerRepository workerRepository;
    private CompanyRepository companyRepository;

    public String createWorker(CreateWorkerRequest request) {
        var worker = workerRepository.save(
                Worker.builder()
                        .name(request.getName())
                        .surname(request.getSurname())
                        .dni(request.getDni())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .phone(request.getPhone())
                        .address(request.getAddress())
                        .city(request.getCity())
                        .postalCode(request.getPostalCode())
                        .type("WORKER")
                        .build()
        );

        return worker.getId();
    }

    public String createCompany (CreateCompanyRequest request) {
        var company = companyRepository.save(
                Company.builder()
                        .name(request.getName())
                        .cuit(request.getCuit())
                        .representativeName(request.getRepresentativeName())
                        .representativeSurname(request.getRepresentativeSurname())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .address(request.getAddress())
                        .city(request.getCity())
                        .postalCode(request.getPostalCode())
                        .type("COMPANY")
                        .build()
        );

        return company.getId();
    }


}
