package com.tsys.tsep.controller;

import com.tsys.tsep.model.AccountDetails;
import com.tsys.tsep.model.AccountDetailsVO;
import com.tsys.tsep.service.AccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
public class AccountDetailsController {


    @Autowired
    private AccountDetailsService accountDetailsService;


    @PostMapping("/api/account-details")
    public ResponseEntity<AccountDetailsVO> saveAccountDetails(@RequestBody AccountDetailsVO accountDetails) {
        return ResponseEntity.ok(accountDetailsService.saveAccountDetails(accountDetails));
    }
}
