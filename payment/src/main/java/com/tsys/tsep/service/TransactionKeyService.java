package com.tsys.tsep.service;

import com.tsys.tsep.model.TransactionKey;
import com.tsys.tsep.repository.TransactionKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionKeyService {


    private final TransactionKeyRepository transactionKeyRepository;

    public TransactionKeyService(TransactionKeyRepository transactionKeyRepository) {
        this.transactionKeyRepository = transactionKeyRepository;
    }

    public String getTransactionKey() {
        TransactionKey transactionKey = transactionKeyRepository.findById(1).orElse(null);
        return (transactionKey != null) ? transactionKey.getTransactionKey() : null;
    }


}
