package com.ig.myfinancesbackend.models;

public class Balance {

    private Double income;
    private Double outcome;
    private Double total;

    public Balance() {

    }

    public Balance(Double income, Double outcome, Double total) {
        this.income = income;
        this.outcome = outcome;
        this.total = total;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getOutcome() {
        return outcome;
    }

    public void setOutcome(Double outcome) {
        this.outcome = outcome;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "income=" + income +
                ", outcome=" + outcome +
                ", total=" + total +
                '}';
    }
}
