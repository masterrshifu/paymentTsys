package com.tsys.tsep.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AchReturn {

    private String deviceID;
    private String transactionKey;
    private String transactionAmount;
    private String transactionID;
    private String firstName;
    private String lastName;
    private String developerID;
}
