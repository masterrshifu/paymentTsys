package com.tsys.tsep.dto;

import com.tsys.tsep.model.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleKeyedRequest {

    private Sale Sale;
}
