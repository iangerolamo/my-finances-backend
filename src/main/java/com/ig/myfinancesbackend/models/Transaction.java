package com.ig.myfinancesbackend.models;

import java.util.UUID;

public class Transaction {

   private UUID id;
   private String title;
   private Double value;
   private String type;


   public Transaction() {
   }

    public Transaction(UUID id, String title, Double value, String type) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value=" + value +
                ", type='" + type + '\'' +
                '}';
    }
}
