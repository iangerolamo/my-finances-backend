package com.ig.myfinancesbackend.models;

import java.util.UUID;

public class Transaction {

   private UUID id;
   private String title;
   private Double value;
   private String transactionType;


   public Transaction() {
   }

    public Transaction(UUID id, String title, Double value, String transactionType) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.transactionType = transactionType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value=" + value +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
