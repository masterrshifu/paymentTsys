package com.tsys.tsep.controller;

import com.tsys.tsep.service.TransactionKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionKeyController {


    @Autowired
    private TransactionKeyService transactionKeyService;


    @GetMapping("/getTransactionKey")
    public String getTransactionKey() {
        return transactionKeyService.getTransactionKey();
    }
}
