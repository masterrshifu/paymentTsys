package com.tsys.tsep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("responseMessage")
    private String responseMessage;

    @JsonProperty("authCode")
    private String authCode;

    @JsonProperty("transactionID")
    private String transactionID;

    @JsonProperty("cardType")
    private String cardType;

    @JsonProperty("maskedCardNumber")
    private Integer maskedCardNumber;

    @Override
    public String toString() {
        return "SaleResponse{" +
                "status='" + status + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", authCode='" + authCode + '\'' +
                ", transactionID='" + transactionID + '\'' +
                ", cardType='" + cardType + '\'' +
                ", maskedCardNumber=" + maskedCardNumber +
                '}';
    }
}
