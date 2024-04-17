package com.tsys.tsep.config;

import com.tsys.tsep.model.TransactionKey;
import com.tsys.tsep.repository.TransactionKeyRepository;
import com.tsys.tsep.service.TransactionKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class TransactionKeyConfig {

    private static TransactionKeyConfig instance;

    @Autowired
    private static TransactionKeyRepository transactionKeyRepository;

    private String transactionKey;

    private TransactionKeyConfig(TransactionKeyRepository transactionKeyRepository) {
        this.transactionKey = "9GLAYQ3LN0CP3I46A6Z2W44FF7SJ8BL9";
        TransactionKey transactionKey = transactionKeyRepository.findById(1).orElse(null);
    }


    public static synchronized TransactionKeyConfig getInstance() {

        if(instance == null) {
            instance = new TransactionKeyConfig(transactionKeyRepository);
        }
        return instance;
    }

    public String getTransactionKey() {
        return transactionKey;
    }

    @Bean
    public static TransactionKeyService transactionKeyService(TransactionKeyRepository transactionKeyRepository) {
        return new TransactionKeyService(transactionKeyRepository);
    }

}
