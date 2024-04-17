package com.tsys.tsep.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.tsys.tsep.dto.AchRequest;
import com.tsys.tsep.dto.AchReturnRequest;
import com.tsys.tsep.model.*;
import com.tsys.tsep.service.AchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AchController {

    @Autowired
    private AchService achService;

    @PostMapping("/getAchRequest/{email}")
    public AchVO getAch(@RequestBody Map<String, Object> ach, @PathVariable String email) {
        return achService.getAchRequest(ach, email);
    }


//    @PostMapping("/getAchResponse/{email}")
//    public ResponseEntity<AchResponse> getAchTransactionResponse(@RequestBody Ach ach, @PathVariable String email) throws JsonProcessingException {
//        return new ResponseEntity<AchResponse>(achService.charge(ach, email), HttpStatus.OK);
//    }

    @GetMapping("/getAccountDetails/{email}")
    public ResponseEntity<AccountDetailsVO> getExistingAccounts(@PathVariable String email) {
        return new ResponseEntity<AccountDetailsVO>(achService.getAccountDetails(email), HttpStatus.OK);
    }

    @PostMapping("/getAchReturnResponse")
    public ResponseEntity<AchReturnResponse> getAchReturnResponse(@RequestBody AchReturn achReturn) throws JsonProcessingException {
        return new ResponseEntity<AchReturnResponse>(achService.postAchReturnRequest(new Gson().toJson(new AchReturnRequest(achReturn))), HttpStatus.OK);
    }

}
