package com.ig.myfinancesbackend.models;

public class Transaction {

    private String id;
    private String title;
    private String transactionType;
    private String categoryId;

    public Transaction() {
    }

    public Transaction(String id, String title, String transactionType, String categoryId) {
        this.id = id;
        this.title = title;
        this.transactionType = transactionType;
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

}
