package com.example.cardealer.service;

import com.example.cardealer.model.dto.salesDto.SaleDiscountDto;

import java.util.List;

public interface SaleService {
    void seedSales();

    List<SaleDiscountDto> getSalesWithAppliedDiscount();
}

