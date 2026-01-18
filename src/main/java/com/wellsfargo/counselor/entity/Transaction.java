package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false)
    private String transactionType; // BUY or SELL

    @Column(nullable = false)
    private String transactionDate;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    protected Transaction() {
        // required by JPA
    }

    public Transaction(String transactionType, String transactionDate,
                       double price, int quantity, Security security) {
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.price = price;
        this.quantity = quantity;
        this.security = security;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
}
