package com.ig.myfinancesbackend.dto;

import com.ig.myfinancesbackend.entities.enums.TypeTransaction;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TransactionDTO {

    private Integer id;
    private String description;
    private Integer mounth;
    private Integer year;
    private Double value;
    private Integer user;
    private String type;
}
