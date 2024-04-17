package com.tsys.tsep.service;

import com.tsys.tsep.model.AccountDetails;
import com.tsys.tsep.model.AccountDetailsVO;
import com.tsys.tsep.repository.AccountDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsService {

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;

    public AccountDetailsVO saveAccountDetails(AccountDetailsVO accountDetailsVO) {
        return accountDetailsRepository.save(accountDetailsVO);
    }


}
