package com.ig.myfinancesbackend.entities;

import com.ig.myfinancesbackend.entities.enums.TypeTransaction;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table
public class Transaction {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer id;

   private String description;

   private Integer mounth;

   private Integer year;

   private double value;

   private TypeTransaction type;

}
