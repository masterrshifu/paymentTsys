package com.tsys.tsep.model;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
public class Sale {

/*    {
    "Sale": {
        "deviceID": "88700000035204",
        "transactionKey": "9GLAYQ3LN0CP3I46A6Z2W44FF7SJ8BL9",
        "cardDataSource": "INTERNET",
        "transactionAmount": "100",
        "cardNumber": "dBNpZQNf5GfS5439",
        "expirationDate": "12/25",
        "cvv2": "999",
        "addressLine1":"Tempe",
        "zip":"85240",
        "externalReferenceID":"abcder",
        "terminalCapability": "KEYED_ENTRY_ONLY",
        "terminalOperatingEnvironment": "OFF_MERCHANT_PREMISES_UNATTENDED",
        "cardholderAuthenticationMethod": "NOT_AUTHENTICATED",
        "terminalAuthenticationCapability": "NO_CAPABILITY",
        "terminalOutputCapability": "DISPLAY_ONLY",
        "maxPinLength": "NOT_SUPPORTED",
        "terminalCardCaptureCapability": "NO_CAPABILITY",
        "cardholderPresentDetail": "CARDHOLDER_PRESENT",
        "cardPresentDetail": "CARD_PRESENT",
        "cardDataInputMode": "KEY_ENTERED_INPUT",
        "cardholderAuthenticationEntity": "NOT_AUTHENTICATED",
        "cardDataOutputCapability": "NONE",
        "developerID": "003524G001"
    }
}
*/

    private String deviceID;
    private String transactionKey;
    private String cardDataSource;
    private String transactionAmount;
    private String cardNumber;
    private String expirationDate;
    private Integer cvv2;
    private String addressLine1;
    private String zip;
    private String externalReferenceID;
    private String terminalCapability;
    private String terminalOperatingEnvironment;
    private String cardholderAuthenticationMethod;
    private String terminalAuthenticationCapability;
    private String terminalOutputCapability;
    private String maxPinLength;
    private String terminalCardCaptureCapability;
    private String cardholderPresentDetail;
    private String cardPresentDetail;
    private String cardDataInputMode;
    private String cardholderAuthenticationEntity;
    private String cardDataOutputCapability;
    private String developerID;

    public Sale(String deviceID, String transactionKey, String cardDataSource, String transactionAmount, String cardNumber, Integer cvv2, String developerID) {
        this.deviceID = deviceID;
        this.transactionKey = transactionKey;
        this.cardDataSource = cardDataSource;
        this.transactionAmount = transactionAmount;
        this.cardNumber = cardNumber;
        this.cvv2 = cvv2;
        this.developerID = developerID;
    }

    public Sale(String deviceID, String transactionKey, String cardDataSource, String transactionAmount, String cardNumber, String expirationDate, Integer cvv2, String addressLine1, String zip, String externalReferenceID, String terminalCapability, String terminalOperatingEnvironment, String cardholderAuthenticationMethod, String terminalAuthenticationCapability, String terminalOutputCapability, String maxPinLength, String terminalCardCaptureCapability, String cardholderPresentDetail, String cardPresentDetail, String cardDataInputMode, String cardholderAuthenticationEntity, String cardDataOutputCapability, String developerID) {
        this.deviceID = deviceID;
        this.transactionKey = transactionKey;
        this.cardDataSource = cardDataSource;
        this.transactionAmount = transactionAmount;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv2 = cvv2;
        this.addressLine1 = addressLine1;
        this.zip = zip;
        this.externalReferenceID = externalReferenceID;
        this.terminalCapability = terminalCapability;
        this.terminalOperatingEnvironment = terminalOperatingEnvironment;
        this.cardholderAuthenticationMethod = cardholderAuthenticationMethod;
        this.terminalAuthenticationCapability = terminalAuthenticationCapability;
        this.terminalOutputCapability = terminalOutputCapability;
        this.maxPinLength = maxPinLength;
        this.terminalCardCaptureCapability = terminalCardCaptureCapability;
        this.cardholderPresentDetail = cardholderPresentDetail;
        this.cardPresentDetail = cardPresentDetail;
        this.cardDataInputMode = cardDataInputMode;
        this.cardholderAuthenticationEntity = cardholderAuthenticationEntity;
        this.cardDataOutputCapability = cardDataOutputCapability;
        this.developerID = developerID;
    }
}
