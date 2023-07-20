package com.example.cardealer.service.impl;

import com.example.cardealer.model.dto.customersDto.CustomerBirthdateOrderedDto;
import com.example.cardealer.model.dto.customersDto.CustomerSeedDto;
import com.example.cardealer.model.dto.customersDto.CustomerTotalSalesDto;
import com.example.cardealer.model.entities.Customer;
import com.example.cardealer.model.entities.Part;
import com.example.cardealer.repositories.CustomerRepository;
import com.example.cardealer.service.CustomerService;
import com.example.cardealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.cardealer.constants.GlobalConstants.RESOURCES_FILES_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final String CUSTOMERS_FILE = "customers.json";
    private final CustomerRepository customerRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomers() throws IOException {
        if (customerRepository.count() > 0) {
            return;
        }

        String content = Files.readString(Path.of(RESOURCES_FILES_PATH + CUSTOMERS_FILE));

        CustomerSeedDto[] customerSeedDtos = gson.fromJson(content, CustomerSeedDto[].class);

        Arrays.stream(customerSeedDtos)
                .map(customerSeedDto -> modelMapper.map(customerSeedDto, Customer.class))
                .forEach(customerRepository::save);
    }

    @Override
    public Customer findRandomCustomer() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, customerRepository.count() + 1);

        return customerRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<CustomerBirthdateOrderedDto> getAllCustomersByBirthdate() {
        return customerRepository.findAllByBirthDateAscAndYoungDriverDesc()
                .stream()
                .filter(validationUtil::isValid)
                .map(customer -> modelMapper.map(customer, CustomerBirthdateOrderedDto.class))
                .toList();
    }

    @Override
    public List<CustomerTotalSalesDto> getTotalSalesByCustomer() {
        return customerRepository.findAllBySalesIsNotNull()
                .stream()
                .filter(validationUtil::isValid)
                .map(customer -> {
                    CustomerTotalSalesDto customerTotalSalesDto = modelMapper.map(customer, CustomerTotalSalesDto.class);
                    customerTotalSalesDto.setBoughtCars(customer.getSales().size());

                    //намираме цялата сума
                    BigDecimal spentMoney = customer.getSales()
                            .stream()
                            .map(sale -> {
                                //намираме цената на колата, като сума от частите й
                                BigDecimal priceOfCar = sale.getCar().getParts().stream().map(Part::getPrice)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                                //включваме отстъпката
                                return priceOfCar.subtract(priceOfCar.multiply(sale.getDiscount()));
                            }).reduce(BigDecimal.ZERO, BigDecimal::add);

                    // закръгляме сумата до 2и знак
                    customerTotalSalesDto.setSpentMoney(spentMoney.setScale(2, RoundingMode.CEILING));

                    return customerTotalSalesDto;
                })
                //сортираме по зададените праметри
                .sorted(Comparator.comparing(CustomerTotalSalesDto::getSpentMoney)
                        .thenComparing(CustomerTotalSalesDto::getBoughtCars).reversed())
                .toList();
    }
}
