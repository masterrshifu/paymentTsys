package com.tsys.tsep.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.tsys.tsep.dto.SaleKeyedRequest;
import com.tsys.tsep.model.Sale;
import com.tsys.tsep.model.TSEPToken;
import com.tsys.tsep.repository.TSEPRepository;
import com.tsys.tsep.service.SaleKeyedService;
import com.tsys.tsep.service.TSEPTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api")
public class TSEPController {

    @Autowired
    private TSEPTokenService tsepTokenService;

    @Autowired
    private SaleKeyedService saleKeyedService;



    @PostMapping("/getTSEPToken")
    public ResponseEntity<String> generateTSEPToken(@RequestBody TSEPToken tsepToken) throws JsonProcessingException {
        TSEPToken tsepToken1 = tsepTokenService.generateTSEPToken(tsepToken.getResponseCode(), tsepToken.getStatus(), tsepToken.getMessage(), tsepToken.getTsepToken(), tsepToken.getCardHolderName(), tsepToken.getTransactionID());
        System.out.println(tsepToken1);
        Sale sale = saleKeyedService.getSaleObject(tsepToken1);
        String saleResponse = getSalesResponse(sale);
        return new ResponseEntity<String>(saleResponse, HttpStatus.OK);
    }

    @PostMapping("/saveTSEPToken")
    public ResponseEntity<String> saveTSEPToken(@RequestBody TSEPToken tsepToken) {
        tsepTokenService.saveTSEPToken(tsepToken);
        return new ResponseEntity<String>("TSEP Details Saved Successfully",HttpStatus.OK);
    }

    public String getSalesResponse(Sale sale) throws JsonProcessingException {
        return saleKeyedService.postDataToApi(new Gson().toJson(new SaleKeyedRequest(sale)));
    }



}
