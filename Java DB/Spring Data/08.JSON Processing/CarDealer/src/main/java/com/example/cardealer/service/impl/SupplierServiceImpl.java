package com.example.cardealer.service.impl;

import com.example.cardealer.model.dto.suppliersDto.SupplierNotImportersDto;
import com.example.cardealer.model.dto.suppliersDto.SupplierSeedDto;
import com.example.cardealer.model.entities.Supplier;
import com.example.cardealer.repositories.SupplierRepository;
import com.example.cardealer.service.SupplierService;
import com.example.cardealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.cardealer.constants.GlobalConstants.RESOURCES_FILES_PATH;

@Service
public class SupplierServiceImpl implements SupplierService {
    private static final String SUPPLIERS_FILE = "suppliers.json";
    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if (supplierRepository.count() > 0) {
            return;
        }
        String content = Files.readString(Path.of(RESOURCES_FILES_PATH + SUPPLIERS_FILE));

        SupplierSeedDto[] supplierSeedDtos = gson.fromJson(content, SupplierSeedDto[].class);

        Arrays.stream(supplierSeedDtos)
                .filter(validationUtil::isValid)
                .map(supplierSeedDto -> modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(supplierRepository::save);

    }

    @Override
    public Supplier findRandomSupplier() {
        long randomId = ThreadLocalRandom //по този начин взимаме Random id
                .current().nextLong(1, supplierRepository.count() + 1);

        return supplierRepository
                .findById(randomId)
                .orElse(null); //връщаме random Supplier
    }

    @Override
    public List<SupplierNotImportersDto> getAllSuplliersNotImporting() {
        return supplierRepository.findByIsImporterFalse()
                .stream()
                .filter(validationUtil::isValid)
                .map(supplier -> {
                    SupplierNotImportersDto localSupplier = modelMapper.map(supplier, SupplierNotImportersDto.class);
                    localSupplier.setPartsCount(supplier.getParts().size());
                    return localSupplier;
                })
                .toList();
    }
}
