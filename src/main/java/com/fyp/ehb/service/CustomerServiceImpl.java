package com.fyp.ehb.service;

import com.fyp.ehb.domain.Business;
import com.fyp.ehb.domain.Customer;
import com.fyp.ehb.model.Request.SignupRequest;
import com.fyp.ehb.repository.BusinessDao;
import com.fyp.ehb.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private BusinessDao businessDao;

    @Override
    public Customer registerCustomer(SignupRequest signupRequest) throws Exception {

        Customer customer = new Customer(
                                signupRequest.getUsername(),
                                signupRequest.getMobileNo(),
                                signupRequest.getEmail(),
                                signupRequest.getPassword());


        Business business = new Business(
                signupRequest.getBusinessName(),
                signupRequest.getBusinessAddress(),
                signupRequest.getTypeOfProduct(),
                signupRequest.getBusinessRegistrationNo()
        );

        businessDao.save(business);

        customer.setBusinesses(business);
        customerDao.save(customer);

        return customer;

    }
}
