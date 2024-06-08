package org.flessi.api.repository;

import org.flessi.api.model.entity.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WorkerRepository extends MongoRepository<Worker, String> {
    List<Worker> findByType(String type);
}
