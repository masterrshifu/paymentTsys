package com.tsys.tsep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDetailsVO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "bank_name")
    private String bankName;

//    @Column(name = "routing_number")
//    private String routingNumber;
//
//    @Column(name = "account_number")
//    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

//    @Column(name = "check_number")
//    private String checkNumber;

}

