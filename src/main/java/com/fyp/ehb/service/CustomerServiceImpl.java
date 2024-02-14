package com.fyp.ehb.service;

import com.fyp.ehb.domain.Business;
import com.fyp.ehb.domain.Customer;
import com.fyp.ehb.model.Request.SignupRequest;
import com.fyp.ehb.repository.BusinessDao;
import com.fyp.ehb.repository.CustomerDao;
import com.fyp.ehb.util.EhbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.fyp.ehb.model.Response.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private MongoTemplate mongoTemplate;

	@Autowired
	private CustomerDao customerDao;

    @Autowired
    private BusinessDao businessDao;

    @Override
    public Customer registerCustomer(SignupRequest signupRequest) throws Exception {

        Customer customer = new Customer();

        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(signupRequest.getUsername()));
        Customer cust=  mongoTemplate.findOne(query, Customer.class);

        if(cust != null){
            throw new Exception("username already exists");
        }

        customer.setUsername(signupRequest.getUsername());
        customer.setName(signupRequest.getName());
        customer.setMobile(signupRequest.getMobileNo());
        customer.setEmail(signupRequest.getEmail());
        customer.setNic(signupRequest.getNic());
        customer.setLanguage(signupRequest.getLanguage());

        String hashedPwd = EhbUtil.computeSHA256Hash(signupRequest.getPassword());
        customer.setPassword(hashedPwd);

        Business business = new Business();

        Query queryB = new Query();
        query.addCriteria(Criteria.where("businessName").is(signupRequest.getUsername()));
        Business busi =  mongoTemplate.findOne(queryB, Business.class);

        if(busi != null){
            throw new Exception("business name already exists");
        }

        business.setBusinessName(signupRequest.getBusinessName());
        business.setBusinessAddress(signupRequest.getBusinessAddress());
        business.setBusinessRegistrationNo(signupRequest.getBusinessRegistrationNo());
        business.setTypeOfProduct(signupRequest.getTypeOfProduct());

        Business business1 = businessDao.save(business);

        customer.setBusiness(business1);

        return customerDao.save(customer);

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
