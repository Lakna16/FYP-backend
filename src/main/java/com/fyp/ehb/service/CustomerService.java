package com.fyp.ehb.service;

import com.fyp.ehb.model.CustomerResponse;

public interface CustomerService {

	public CustomerResponse login(String username, String password);

}
