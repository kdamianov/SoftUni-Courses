package com.example.cardealer;

import com.example.cardealer.model.dto.carsDto.CarPartsListDto;
import com.example.cardealer.model.dto.carsDto.CarToyotaDto;
import com.example.cardealer.model.dto.customersDto.CustomerBirthdateOrderedDto;
import com.example.cardealer.model.dto.customersDto.CustomerTotalSalesDto;
import com.example.cardealer.model.dto.salesDto.SaleDiscountDto;
import com.example.cardealer.model.dto.suppliersDto.SupplierNotImportersDto;
import com.example.cardealer.service.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static com.example.cardealer.constants.GlobalConstants.*;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final Gson gson;
    Scanner scanner = new Scanner(System.in);

    public CommandLineRunner(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, Gson gson) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("Please select query No (1-6):");
        int queryNum = Integer.parseInt(scanner.nextLine());
        switch (queryNum) {
            case 1 -> getOrderedCustomers();
            case 2 -> getCarsFromMakeToyota();
            case 3 -> getLocalSuppliers();
            case 4 -> getCarsWithTheirListOfParts();
            case 5 -> getTotalSalesByCustomer();
            case 6 -> getSalesWithAppliedDiscount();
        }
    }

    private void getSalesWithAppliedDiscount() throws IOException {
        List<SaleDiscountDto> salesWithAppliedDiscount = saleService.getSalesWithAppliedDiscount();

        String content = gson.toJson(salesWithAppliedDiscount);

        writeToFile(RESOURCES_FILES_PATH + SALES_DISCOUNTS, content);

    }

    private void getTotalSalesByCustomer() throws IOException {
        List<CustomerTotalSalesDto> totalSalesByCustomer = customerService.getTotalSalesByCustomer();

        String content = gson.toJson(totalSalesByCustomer);

        writeToFile(RESOURCES_FILES_PATH + CUSTOMER_TOTAL_SALES, content);
    }

    private void getCarsWithTheirListOfParts() throws IOException {
        List<CarPartsListDto> allCarsWithTheirListOfParts = carService.getAllCarsWithTheirListOfParts();

        String content = gson.toJson(allCarsWithTheirListOfParts);

        writeToFile(RESOURCES_FILES_PATH + CARS_AND_PARTS, content);
    }

    private void getLocalSuppliers() throws IOException {
        List<SupplierNotImportersDto> localSuppliers = supplierService.getAllSuplliersNotImporting();

        String content = gson.toJson(localSuppliers);

        writeToFile(RESOURCES_FILES_PATH + LOCAL_SUPPLIERS, content);
    }

    private void getCarsFromMakeToyota() throws IOException {
        String make = "Toyota";
        List<CarToyotaDto> allCarsFromMakeToyota = carService.getAllCarsFromMakeToyota(make);

        String content = gson.toJson(allCarsFromMakeToyota);

        writeToFile(RESOURCES_FILES_PATH + TOYOTA_CARS, content);
    }

    private void getOrderedCustomers() throws IOException {
        List<CustomerBirthdateOrderedDto> allCustomersByBirthdate = customerService.getAllCustomersByBirthdate();

        String content = gson.toJson(allCustomersByBirthdate);
        writeToFile(RESOURCES_FILES_PATH + ORDERED_CUSTOMERS_FILE, content);

    }

    private void writeToFile(String path, String content) throws IOException {
        Files.write(Path.of(path), Collections.singleton(content));
    }

    private void seedData() throws IOException {
        supplierService.seedSuppliers();
        partService.seedParts();
        carService.seedCars();
        customerService.seedCustomers();
        saleService.seedSales();
    }
}
