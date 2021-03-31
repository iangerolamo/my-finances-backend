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
@Table(name = "transaction")
public class Transaction {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "description")
   private String description;

   @Column(name = "mounth")
   private Integer mounth;

   @Column(name = "year")
   private Integer year;

   @ManyToOne
   @JoinColumn(name = "id_user")
   private User user;

   @Column(name = "value")
   private BigDecimal value;

   @Column(name = "type")
   @Enumerated(value = EnumType.STRING)
   private TypeTransaction type;

}
