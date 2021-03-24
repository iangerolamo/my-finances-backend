package com.ig.myfinancesbackend.entities;

import lombok.*;

import javax.persistence.*;

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
   private String title;
   private Double value;
   private String type;

}
