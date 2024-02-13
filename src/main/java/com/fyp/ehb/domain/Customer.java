package com.fyp.ehb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("customers")
public class Customer {

	@Id
	private String id;
	private String nic;
	private String name;
	private String mobileNo;
	private String email;
	private String pwd;
	private String username;
	
}
