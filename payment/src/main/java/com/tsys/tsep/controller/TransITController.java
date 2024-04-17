package com.tsys.tsep.controller;


import com.tsys.tsep.model.Merchant;
import com.tsys.tsep.service.TransITCryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransITController {

    private final TransITCryptService transITCryptService;

    @Autowired
    public TransITController(TransITCryptService transITCryptService) {
        this.transITCryptService = transITCryptService;
    }

    @PostMapping("/generateManifest")
    public String generateManifest(@RequestBody Merchant merchant) {
        return transITCryptService.encryptManifest(merchant);
    }
}
