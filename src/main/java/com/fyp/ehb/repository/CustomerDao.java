package com.fyp.ehb.repository;

import com.fyp.ehb.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDao extends MongoRepository<Customer, String> {
}
