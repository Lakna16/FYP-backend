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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.ehb.model.CustomerResponse;
import com.fyp.ehb.model.MainResponse;
import com.fyp.ehb.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

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

	@GetMapping(value="/login")
	public MainResponse login(
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password
			) throws Exception {

		CustomerResponse customerResp = customerService.login(username, password);

		MainResponse mainResponse = new MainResponse();
		mainResponse.setResponseCode("000");
		mainResponse.setResponseObject(customerResp);

		return mainResponse;

	}

	//registration
}
