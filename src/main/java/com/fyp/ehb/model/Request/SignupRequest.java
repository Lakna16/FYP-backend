package com.fyp.ehb.model.Request;

import lombok.Data;

@Data
public class SignupRequest {

    private String username;
    private String mobileNo;
    private String email;
    private String password;
    private String businessName;
    private String businessAddress;
    private String typeOfProduct;
    private String businessRegistrationNo;

}
