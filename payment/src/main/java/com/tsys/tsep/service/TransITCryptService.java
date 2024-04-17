package com.tsys.tsep.service;


import com.tsys.tsep.model.Merchant;
import org.springframework.stereotype.Service;

@Service
public class TransITCryptService {

    public String encryptManifest(Merchant merchant) {
        return TransITCrypt.encryptManifest(
                merchant.getMerchantID(),
                merchant.getDeviceID(),
                merchant.getAmount(),
                merchant.getTransactionKey()
        );
    }
}
