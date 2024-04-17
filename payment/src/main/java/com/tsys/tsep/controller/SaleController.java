package com.tsys.tsep.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.tsys.tsep.dto.SaleKeyedRequest;
import com.tsys.tsep.model.Sale;
import com.tsys.tsep.service.SaleKeyedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    @Autowired
    private SaleKeyedService saleKeyedService;


    @PostMapping("/getSaleResponse")
    public ResponseEntity<String> getSaleTransactionResponse(@RequestBody Sale sale) throws JsonProcessingException {
        return new ResponseEntity<>(saleKeyedService.postDataToApi(new Gson().toJson(new SaleKeyedRequest(sale))), HttpStatus.OK);
    }
}
