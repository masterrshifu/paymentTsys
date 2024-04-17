package com.tsys.tsep.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TSEPToken {


    private String responseCode;

    private String status;

    private String message;

    @Id
    private String tsepToken;

    private String transactionID;

//    @Size(min = 3, max = 3)
//    private Integer cvv2;

    private String cardHolderName;


    @Override
    public String toString() {
        return "TSEPToken{" +
                "responseCode='" + responseCode + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", tsepToken='" + tsepToken + '\'' +
                ", transactionID='" + transactionID + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                '}';
    }
}
