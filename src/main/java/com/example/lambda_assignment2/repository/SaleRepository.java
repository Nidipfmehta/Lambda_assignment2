package com.example.lambda_assignment2.repository;


import com.example.lambda_assignment2.models.Sale;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class SaleRepository {
    private final List<Sale> sales = new ArrayList<>();

    public Sale createSale(Sale sale) {
//        Sale sale1 = new Sale(sale.getProductName(), sale.getRegion(), sale.getQuantity(), sale.getPricePerUnit());
        sales.add(sale);
        return sale;
    }

    public List<Sale> getAllSale() {
        return sales;
    }
}
