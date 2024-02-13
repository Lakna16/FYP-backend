package com.fyp.ehb.service;

import com.fyp.ehb.domain.Business;
import com.fyp.ehb.domain.Customer;
import com.fyp.ehb.model.Request.SignupRequest;
import com.fyp.ehb.repository.BusinessDao;
import com.fyp.ehb.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fyp.ehb.domain.Customer;
import com.fyp.ehb.model.CustomerResponse;
import com.fyp.ehb.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private MongoTemplate mongoTemplate;

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
	@Override
	public CustomerResponse login(String username, String password) {

        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        Customer customer =  mongoTemplate.findOne(query, Customer.class);

        if(customer == null) {
        	//throw exception
        }

        return null;

	}

}
