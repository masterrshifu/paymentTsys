package com.tsys.tsep.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tsys.tsep.model.AccountDetails;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ach {

    private String deviceID;
    private String transactionKey;
    private String transactionAmount;
    private AccountDetails accountDetails;
    private String achSecCode;
    private String originateDate;
    private String addenda;
    private String developerID;

}
