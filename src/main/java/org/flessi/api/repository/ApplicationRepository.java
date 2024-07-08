package org.flessi.api.repository;

import org.flessi.api.model.entity.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Application, String> {
    List<Application> findByWorkerId(String workerId);
}
