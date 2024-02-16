package com.fyp.ehb.service;

import com.fyp.ehb.domain.Customer;
import com.fyp.ehb.model.Request.SignupRequest;
import com.fyp.ehb.model.Response.CustomerResponse;

public interface CustomerService {

    Customer registerCustomer(SignupRequest signupRequest) throws Exception;
	public CustomerResponse login(String username, String password);

}
