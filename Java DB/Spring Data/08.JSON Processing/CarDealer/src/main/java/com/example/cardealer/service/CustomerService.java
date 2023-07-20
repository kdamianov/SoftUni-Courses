package com.example.cardealer.service;


import com.example.cardealer.model.dto.customersDto.CustomerBirthdateOrderedDto;
import com.example.cardealer.model.dto.customersDto.CustomerTotalSalesDto;
import com.example.cardealer.model.entities.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    void seedCustomers() throws IOException;

    Customer findRandomCustomer();

    List<CustomerBirthdateOrderedDto> getAllCustomersByBirthdate();

    List<CustomerTotalSalesDto> getTotalSalesByCustomer();
}
