package org.flessi.api.repository;

import org.flessi.api.model.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {

}
