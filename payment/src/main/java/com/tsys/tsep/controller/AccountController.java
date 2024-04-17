package com.tsys.tsep.controller;

import com.tsys.tsep.model.Account;
import com.tsys.tsep.service.AccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/api/account")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

}
