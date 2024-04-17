package com.tsys.tsep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDetails {

    private String bankName;
    private String routingNumber;
    private String accountNumber;
    private String accountType;
    private String checkNumber;

    public AccountDetails(AccountDetailsVO accountDetailsVO, String routingNumber, String accountNumber, String checkNumber) {
        this.bankName = accountDetailsVO.getBankName();
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.accountType = accountDetailsVO.getAccountType();
        this.checkNumber = checkNumber;
    }

}
