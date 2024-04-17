package com.tsys.tsep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AchVO {

    private String deviceID;
    private String transactionKey;
    private String transactionAmount;
    private AccountDetails accountDetails;
    private String achSecCode;
    private String originateDate;
    private String addenda;
    private String firstName;
    private String lastName;
    private String customerPhone;
    private String addressLine1;
    private String addressLine2;
    private String zip;
    private String city;
    private String state;
    private String country;
    private String developerID;

}
