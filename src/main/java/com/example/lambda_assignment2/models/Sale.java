package com.example.lambda_assignment2.models;

import lombok.Getter;

@Getter
public class Sale {
//    private static int saleCount = 0;
//    private int saleId;
    private String productName;
    private String region;
    private int quantity;
    private double pricePerUnit;

    public Sale(String productName, String region, int quantity, double pricePerUnit) {
//        this.saleId = saleCount++;
        this.productName =  productName;
        this.region = region;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
}
