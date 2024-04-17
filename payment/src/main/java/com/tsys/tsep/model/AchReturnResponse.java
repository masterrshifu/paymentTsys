package com.tsys.tsep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AchReturnResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("responseMessage")
    private String responseMessage;

    @JsonProperty("taskID")
    private String taskID;

    @JsonProperty("transactionID")
    private String transactionID;

    @JsonProperty("orderNumber")
    private String orderNumber;

    @JsonProperty("externalReferenceID")
    private String externalReferenceID;

    @JsonProperty("returnedAmount")
    private String returnedAmount;

    @JsonProperty("customerReceipt")
    private String customerReceipt;

    @JsonProperty("merchantReceipt")
    private String merchantReceipt;


}
