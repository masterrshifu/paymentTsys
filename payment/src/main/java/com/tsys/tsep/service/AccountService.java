package com.tsys.tsep.service;

import com.tsys.tsep.model.Account;
import com.tsys.tsep.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    @Autowired
    private AccountRepository accountRepository;


    public Account createAccount(Account account) {
        return accountRepository.save(account);

    }


}
