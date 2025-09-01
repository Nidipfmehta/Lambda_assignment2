package com.example.lambda_assignment2.controller;


import com.example.lambda_assignment2.models.Sale;
import com.example.lambda_assignment2.repository.SaleRepository;
import com.example.lambda_assignment2.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping()
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        final Sale sale1 = saleService.createSale(sale);
        return ResponseEntity.ok(sale1);
    }

    @GetMapping("/total")
    public ResponseEntity<String> totalSaleRevenue() {
        return ResponseEntity.ok("Total Sale Revenue : " + saleService.totalSaleRevenue());
    }

    @GetMapping("/avg")
    public ResponseEntity<String> avgSaleRevenue() {
        return ResponseEntity.ok("Average Sale Revenue : " + saleService.avgSaleRevenue());
    }

    @GetMapping("/top")
    public ResponseEntity<List<String>> bestProductName() {
        return ResponseEntity.ok(saleService.bestProductName());
    }
}
