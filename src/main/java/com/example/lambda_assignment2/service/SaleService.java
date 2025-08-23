package com.example.lambda_assignment2.service;


import com.example.lambda_assignment2.models.Sale;
import com.example.lambda_assignment2.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SaleService {
    private SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Sale createSale(Sale sale) {
        return saleRepository.createSale(sale);
    }

    public Double totalSaleRevenue() {
        Collection<Sale> sales = saleRepository.getAllSale();
        return sales.stream().mapToDouble(sale -> sale.getPricePerUnit()*sale.getQuantity()).sum();
    }

    public Double avgSaleRevenue() {
        Collection<Sale> sales = saleRepository.getAllSale();
        if(sales.isEmpty()) {
            return 0.0;
        }
        return totalSaleRevenue() / sales.size();
    }

    public List<String> bestProductName() {
        Collection<Sale> sales = saleRepository.getAllSale();
//        Map<String, Double> revenueByProduct = sales.stream()
//                .collect(Collectors.groupingBy(Sale::getProductName, ))
        return new ArrayList<>();
    }

}
