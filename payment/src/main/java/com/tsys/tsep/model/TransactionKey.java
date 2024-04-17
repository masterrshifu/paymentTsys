package com.tsys.tsep.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransactionKey {

    @Id
    private Integer id;

    private String transactionKey;
}
