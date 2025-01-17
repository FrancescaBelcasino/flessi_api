package org.flessi.api.service;

import lombok.AllArgsConstructor;
import org.flessi.api.model.dto.request.CreateCompanyRequest;
import org.flessi.api.model.dto.request.CreateWorkerRequest;
import org.flessi.api.model.dto.request.LoginRequest;
import org.flessi.api.model.entity.Company;
import org.flessi.api.model.entity.User;
import org.flessi.api.model.entity.Worker;
import org.flessi.api.repository.CompanyRepository;
import org.flessi.api.repository.UserRepository;
import org.flessi.api.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private WorkerRepository workerRepository;
    private CompanyRepository companyRepository;
    private UserRepository userRepository;

    public String createWorker(CreateWorkerRequest request) {
        Worker worker = workerRepository.save(
                Worker.builder()
                        .name(request.getName())
                        .surname(request.getSurname())
                        .dni(request.getDni())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .phone(request.getPhone())
                        .address(request.getAddress())
                        .city(request.getCity())
                        .skills(new ArrayList<>())
                        .interests(new ArrayList<>())
                        .experiences(new ArrayList<>())
                        .type("WORKER")
                        .build()
        );

        return worker.getId();
    }

    public String createCompany (CreateCompanyRequest request) {
        Company company = companyRepository.save(
                Company.builder()
                        .name(request.getName())
                        .cuit(request.getCuit())
                        .representativeName(request.getRepresentativeName())
                        .representativeSurname(request.getRepresentativeSurname())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .address(request.getAddress())
                        .city(request.getCity())
                        .type("COMPANY")
                        .build()
        );

        return company.getId();
    }

    public Optional<String> genericLogin(LoginRequest request){
        return userRepository
                .findByEmail(request.getEmail())
                .filter(user -> user.getPassword().equals(request.getPassword()))
                .map(User::getId);
    }

    public Optional<Worker> fetchWorker(String workerID) {
        return workerRepository
                .findById(workerID);
    }

    public Optional<Company> fetchCompany(String companyID) {
        return companyRepository
                .findById(companyID);
    }

    public String addWorkerSkill(String workerID, String skill) {
        Optional<Worker> worker = workerRepository.findById(workerID);

        worker.ifPresent(w -> {
            w.getSkills().add(skill);

            workerRepository.save(w);
        });

        return worker.isPresent() ? skill : null;
    }

    public String addWorkerInterest(String workerID, String interest) {
        Optional<Worker> worker = workerRepository.findById(workerID);

        worker.ifPresent(w -> {
            w.getInterests().add(interest);

            workerRepository.save(w);
        });

        return worker.isPresent() ? interest : null;
    }

    public String addWorkerExperience(String workerID, String experience) {
        Optional<Worker> worker = workerRepository.findById(workerID);

        worker.ifPresent(w -> {
            w.getExperiences().add(experience);

            workerRepository.save(w);
        });

        return worker.isPresent() ? experience : null;
    }
}
