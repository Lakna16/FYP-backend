package com.fyp.ehb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fyp.ehb.domain.Customer;

public interface CustomerDao extends MongoRepository<Customer, String> {
import com.fyp.ehb.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDao extends MongoRepository<Customer, String> {
}

