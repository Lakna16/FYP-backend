package com.fyp.ehb.controller;

import com.fyp.ehb.domain.Customer;
import com.fyp.ehb.model.Request.SignupRequest;
import com.fyp.ehb.model.Response.GlobalResponse;
import com.fyp.ehb.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

	//registration
    @PostMapping("/signup")
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody SignupRequest signupRequest) throws Exception {

        Customer customer = customerService.registerCustomer(signupRequest);

        if (customer == null) {
            return ResponseEntity
                    .badRequest()
                    .body(new GlobalResponse("999","Failed"));
        }
        else{
            return ResponseEntity
                    .ok()
                    .body(new GlobalResponse("000", "Success"));
        }
    }

	
	//login
}
