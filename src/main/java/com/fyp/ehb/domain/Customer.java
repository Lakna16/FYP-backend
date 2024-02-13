package com.fyp.ehb.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customers")
@Data
public class Customer {

    @Id
    private String userAccountId;

    @NotBlank
    private String username;

    @NotBlank
    @Field("mobile_no")
    private String mobileNo;

    private String email;

    @NotBlank
    private String password;

    @Field("user_login_count")
    private int userLoginCount;

    @Field("user_password_reset_count")
    private int userPasswordResetCount;

    @DBRef
    private Business businesses;

    public Customer(String username, String mobileNo, String email, String password) {
        this.username = username;
        this.mobileNo = mobileNo;
        this.email = email;
        this.password = password;
    }
}
