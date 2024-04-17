package com.tsys.tsep.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsys.tsep.model.AchReturnResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AchTransactionReturnResponse {

    @JsonProperty("AchReturnResponse")
    private AchReturnResponse AchReturnResponse;

    public void setAchReturnResponse(AchReturnResponse achReturnResponse) {
        this.AchReturnResponse = achReturnResponse;
    }
}
