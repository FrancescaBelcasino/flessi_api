package org.flessi.api.repository;

import org.flessi.api.model.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {
    List<Company> findByType(String type);
}
