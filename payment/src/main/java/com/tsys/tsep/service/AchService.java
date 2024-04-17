package com.tsys.tsep.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tsys.tsep.dto.AchRequest;
import com.tsys.tsep.dto.AchTransactionResponse;
import com.tsys.tsep.dto.AchTransactionReturnResponse;
import com.tsys.tsep.model.*;
import com.tsys.tsep.repository.AccountDetailsRepository;
import com.tsys.tsep.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;

import java.util.Map;

@Service
public class AchService {

    private final String deviceId = "88700000035204";
    private final String transactionKey = "9GLAYQ3LN0CP3I46A6Z2W44FF7SJ8BL9";
    private final String developerID = "003524G001";

    private final String apiUrl = "https://stagegw.transnox.com/servlets/TransNox_API_Server";

    private final RestTemplate restTemplate;

    @Autowired
    public AchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private AccountDetailsService accountDetailsService;

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;


    @Autowired
    private AccountRepository accountRepository;

    public AchVO getAchRequest1(Ach ach, String email, String routingNumber, String accountNumber, String checkNumber) {
        AccountDetailsVO accountDetailsVO = null;
        AccountDetails accountDetails = null;
        Account account = null;
        if(accountDetailsRepository.existsByEmail(email)) {
            accountDetailsVO = accountDetailsRepository.findByEmail(email);
            accountDetails = new AccountDetails(accountDetailsVO, accountNumber, routingNumber, checkNumber);
        }


        if(accountRepository.existsByEmail(email)) {
            account = accountRepository.findByEmail(email);
        }

        return new AchVO(deviceId, transactionKey, ach.getTransactionAmount(),accountDetails, ach.getAchSecCode(), ach.getOriginateDate(),
                ach.getAddenda(), account.getFirstName(), account.getLastName(), account.getCustomerPhone(), account.getAddressLine1(),
                account.getAddressLine2(), account.getZip(), account.getCity(), account.getState(), account.getCountry(), developerID);
    }

    public AchVO getAchRequest(Map<String, Object> ach, String email) {
        AccountDetails accountDetails = (AccountDetails) ach.get("accountDetails");
        AccountDetailsVO accountDetailsVO = null;
        Account account = null;
        if(accountDetailsRepository.existsByEmail(email)) {
            accountDetailsVO = accountDetailsRepository.findByEmail(email);
        }
        else {
            throw new IllegalArgumentException("Account details not found for email: " + email);
        }

        accountDetails.setBankName(accountDetailsVO.getBankName());
        accountDetails.setAccountType(accountDetailsVO.getAccountType());

        if(accountRepository.existsByEmail(email)) {
            account = accountRepository.findByEmail(email);
        }
        else {
            throw new IllegalArgumentException("Account not found for email: " + email);
        }

        return new AchVO(deviceId, transactionKey, (String) ach.get("transactionAmount"), accountDetails, (String)ach.get("achSecCode"), (String) ach.get("originateDate"),
                (String) ach.get("addenda"), account.getFirstName(), account.getLastName(), account.getCustomerPhone(), account.getAddressLine1(),
                account.getAddressLine2(), account.getZip(), account.getCity(), account.getState(), account.getCountry(), developerID);
    }

    public AccountDetailsVO getAccountDetails(String email) {
        if(accountDetailsRepository.existsByEmail(email)) {
            return accountDetailsRepository.findByEmail(email);
        }
        else {
            throw new IllegalArgumentException("Account details not found for email: " + email);
        }
    }

    public AchResponse charge(Ach ach, String email, String routingNumber, String accountNumber, String checkNumber) throws JsonProcessingException {
        AchVO achDetails = getAchRequest1(ach, email, routingNumber, accountNumber, checkNumber);
        return postDataToApi(new Gson().toJson(new AchRequest(achDetails)));
    }


    public AchResponse postDataToApi(String data) throws JsonProcessingException {
        System.out.println(data);
        String response = getApiResponseData(data);
        System.out.println(response);
        ObjectMapper objectMapper = new ObjectMapper();
        AchTransactionResponse achTransactionResponse = objectMapper.readValue(response, AchTransactionResponse.class);
        AchResponse achResponse = achTransactionResponse.getAchResponse();
        System.out.println(achResponse.toString());
        return achResponse;

    }

    public AchReturnResponse postAchReturnRequest(String data) throws JsonProcessingException {
        System.out.println(data);
        String response = getApiResponseData(data);
        System.out.println(response);
        ObjectMapper objectMapper = new ObjectMapper();
        AchTransactionReturnResponse achTransactionReturnResponse = objectMapper.readValue(response, AchTransactionReturnResponse.class);
        AchReturnResponse achReturnResponse = achTransactionReturnResponse.getAchReturnResponse();
        System.out.println(achReturnResponse.toString());
        return achReturnResponse;

    }

    public String getApiResponseData(String data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        return restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class).getBody();
    }

}
