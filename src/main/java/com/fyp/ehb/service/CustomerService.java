package com.fyp.ehb.service;

import com.fyp.ehb.domain.Customer;
import com.fyp.ehb.model.Request.SignupRequest;

public interface CustomerService {

    Customer registerCustomer(SignupRequest signupRequest) throws Exception;
}
