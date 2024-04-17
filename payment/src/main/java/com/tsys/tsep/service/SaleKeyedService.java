package com.tsys.tsep.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsys.tsep.dto.SaleTransactionResponse;
import com.tsys.tsep.model.Sale;
import com.tsys.tsep.model.SaleResponse;
import com.tsys.tsep.model.TSEPToken;
import com.tsys.tsep.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("ALL")
@Service
public class SaleKeyedService {


    private final String deviceId = "88700000035204";
    private final String transactionKey = "9GLAYQ3LN0CP3I46A6Z2W44FF7SJ8BL9";
    private final String developerID = "003524G001";

    private final String cardDataSource = "INTERNET";

    private final String apiUrl = "https://stagegw.transnox.com/servlets/TransNox_API_Server";


    private final RestTemplate restTemplate;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    public SaleKeyedService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String postDataToApi(String data) throws JsonProcessingException {
        System.out.println(data);
        String response = getApiResponseData(data);
        System.out.println(response);
        ObjectMapper objectMapper = new ObjectMapper();
        SaleTransactionResponse saleTransactionResponse = objectMapper.readValue(response, SaleTransactionResponse.class);
        SaleResponse saleResponse = saleTransactionResponse.getSaleResponse();
        saleRepository.save(saleResponse);
        System.out.println(saleResponse.toString());
        return response;
    }

    public Sale getSaleObject(TSEPToken tsepToken) {
        return new Sale(deviceId,transactionKey, cardDataSource, "2000", tsepToken.getTsepToken(), 233, developerID);
    }

    public Sale getSaleObject(Sale sale) {
        return new Sale(deviceId, transactionKey, cardDataSource, sale.getTransactionAmount(), sale.getCardNumber(), sale.getExpirationDate(), sale.getCvv2()
        , sale.getAddressLine1(), sale.getZip(), sale.getExternalReferenceID(), sale.getTerminalCapability(), sale.getTerminalOperatingEnvironment()
        , sale.getCardholderAuthenticationMethod(), sale.getTerminalAuthenticationCapability(), sale.getTerminalOutputCapability(), sale.getMaxPinLength()
        , sale.getTerminalCardCaptureCapability(), sale.getCardholderPresentDetail(), sale.getCardPresentDetail(), sale.getCardDataInputMode(), sale.getCardholderAuthenticationEntity()
        , sale.getCardDataOutputCapability(), sale.getDeveloperID());
    }

    public String getApiResponseData(String data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
        return restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class).getBody();
    }
}
