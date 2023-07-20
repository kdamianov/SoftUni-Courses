package com.example.cardealer;

import com.example.cardealer.model.dto.customers.CustomerSeedDto;
import com.example.cardealer.service.*;
import com.example.cardealer.util.XMLParser;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private static final String RESOURCES_FILES_PATH = "src/main/resources/files/";
    private static final String CARS_FILE = "cars.xml";
    private static final String CUSTOMERS_FILE = "customers.xml";
    private static final String PARTS_FILE = "parts.xml";
    private static final String SUPPLIERS_FILE = "suppliers.xml";

    private final XMLParser xmlParser;
    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SaleService saleService;
    private final SupplierService supplierService;

    private final Scanner scanner;

    public CommandLineRunner(XMLParser xmlParser,
                             CarService carService,
                             CustomerService customerService,
                             PartService partService,
                             SaleService saleService,
                             SupplierService supplierService,
                             Scanner scanner) {
        this.xmlParser = xmlParser;
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (carService.getCount() == 0) {
            CustomerSeedDto customerSeedDto = xmlParser
                    .fromFile(RESOURCES_FILES_PATH + CARS_FILE, CustomerSeedDto.class);

            customerService.seedCustomers();
        }
    }
}
