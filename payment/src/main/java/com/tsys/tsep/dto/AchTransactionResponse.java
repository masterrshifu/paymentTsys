package com.tsys.tsep.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsys.tsep.model.AchResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AchTransactionResponse {

    @JsonProperty("AchResponse")
    private AchResponse AchResponse;

    public void setAchResponse(AchResponse AchResponse) {
        this.AchResponse = AchResponse;
    }
}
