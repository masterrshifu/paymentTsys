package com.tsys.tsep.service;

import com.tsys.tsep.model.TSEPToken;
import com.tsys.tsep.repository.TSEPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TSEPTokenService {

    @Autowired
    private TSEPRepository tsepRepository;

    public TSEPToken generateTSEPToken(String responseCode, String status, String message, String tsepToken, String cardHolderName, String transactionID) {
        return new TSEPToken(responseCode,status,message,tsepToken,transactionID,cardHolderName);
    }

    public void saveTSEPToken(TSEPToken tsepToken) {
        if(!tsepRepository.existsById(tsepToken.getTsepToken())) {
            tsepRepository.save(tsepToken);
        }

    }


//    public static void main(String[] args) {
//
//        TSEPToken tsepToken = generateTSEPToken("A000","PASS","Active","isbxisubxius",999,"999","bdiusb");
//
//        System.out.println(tsepToken);
//    }

}
