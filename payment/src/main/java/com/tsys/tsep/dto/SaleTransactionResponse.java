package com.tsys.tsep.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsys.tsep.model.SaleResponse;
import lombok.Getter;

@Getter
public class SaleTransactionResponse {

    @JsonProperty("SaleResponse")
    private SaleResponse saleResponse;

    public void setSaleResponse(SaleResponse saleResponse) {
        this.saleResponse = saleResponse;
    }


}
