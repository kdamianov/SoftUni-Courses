package com.example.cardealer.service.impl;

import com.example.cardealer.model.dto.salesDto.SaleDiscountDto;
import com.example.cardealer.model.entities.Part;
import com.example.cardealer.model.entities.Sale;
import com.example.cardealer.repositories.CustomerRepository;
import com.example.cardealer.repositories.SaleRepository;
import com.example.cardealer.service.CarService;
import com.example.cardealer.service.CustomerService;
import com.example.cardealer.service.SaleService;
import com.example.cardealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class SaleServiceImpl implements SaleService {
    private static final String SALES_FILE = "sales.json";
    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final CarService carService;
    private final CustomerService customerService;

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepository saleRepository, CustomerRepository customerRepository, CarService carService, CustomerService customerService, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() { //no SaleSeedDto --> the data is received from the DB
        if (saleRepository.count() > 0) {
            return;
        }

        Set<Sale> sales = new HashSet<>();
        double discount = 0;

        Double[] discountsArr = {0.0, 0.05, 0.10, 0.15, 0.20, 0.30, 0.40, 0.50};

        for (int i = 0; i < customerRepository.count(); i++) {
            Sale sale = new Sale();
            sale.setCar(carService.findRandomCar());
            sale.setCustomer(customerService.findRandomCustomer());
            discount = discountsArr[new Random().nextInt(discountsArr.length - 1)];

            if(sale.getCustomer().isYoungDriver()){
                discount += 0.05;
            }

            sale.setDiscount(BigDecimal.valueOf(discount));
            sales.add(sale);
        }
        saleRepository.saveAll(sales);
    }

    @Override
    public List<SaleDiscountDto> getSalesWithAppliedDiscount() {
        return saleRepository.findAll()
                .stream()
                .filter(validationUtil::isValid)
                .map(sale -> {
                    SaleDiscountDto saleDiscountDto = modelMapper.map(sale, SaleDiscountDto.class);

                    //намираме цената на колата
                    BigDecimal carPrice = sale.getCar().getParts().stream()
                            .map(Part::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    //намираме цената с отстъпка
                    BigDecimal discountCarPrice = carPrice.subtract(carPrice.multiply(sale.getDiscount()));

                    //.setScale(2, RoundingMode.CEILING) --> закръгляне до 2и знак
                    saleDiscountDto.setPrice(carPrice);
                    saleDiscountDto.setPriceWithDiscount(discountCarPrice);

                    return saleDiscountDto;
                })
                .toList();
    }
}
