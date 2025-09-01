package com.example.lambda_assignment2.repository;


import com.example.lambda_assignment2.models.Sale;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<String> bestProductName() {
        Map<String, Double> m1 = sales.stream()
                .collect(Collectors.groupingBy(Sale::getProductName, Collectors.summingDouble(x -> x.getPricePerUnit()*x.getQuantity())));

        OptionalDouble max = m1.values().stream().mapToDouble(Double::doubleValue).max();

        if(max.isEmpty()) {
            return new ArrayList<>();
        }

        double maxVal = max.getAsDouble();

        return m1.entrySet().stream()
                .filter(x -> x.getValue() == maxVal)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
