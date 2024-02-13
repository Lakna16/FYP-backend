package com.fyp.ehb.domain;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "businesses")
public class Business {

    @Id
    private String businessID;

    @NotBlank
    @Field("name")
    private String businessName;

    @Field("address")
    private String businessAddress;

    @Field("product_type")
    private String typeOfProduct;

    @NotBlank
    @Field("registration_no")
    private String businessRegistrationNo;

    public Business(String businessName, String businessAddress, String typeOfProduct, String businessRegistrationNo) {
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.typeOfProduct = typeOfProduct;
        this.businessRegistrationNo = businessRegistrationNo;
    }
}
