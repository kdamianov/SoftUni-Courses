package com.example.cardealer.service.impl;

import com.example.cardealer.model.dto.partsDto.PartSeedDto;
import com.example.cardealer.model.entities.Part;
import com.example.cardealer.repositories.PartRepository;
import com.example.cardealer.service.PartService;
import com.example.cardealer.service.SupplierService;
import com.example.cardealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.cardealer.constants.GlobalConstants.RESOURCES_FILES_PATH;

@Service
public class PartServiceImpl implements PartService {
    private static final String PARTS_FILE = "parts.json";
    private final PartRepository partRepository;
    private final SupplierService supplierService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedParts() throws IOException {
        if (partRepository.count() > 0) {
            return;
        }
        String content = Files.readString(Path.of(RESOURCES_FILES_PATH + PARTS_FILE));

        PartSeedDto[] partSeedDtos = gson.fromJson(content, PartSeedDto[].class);

        Arrays.stream(partSeedDtos)
                .filter(validationUtil::isValid)
                .map(partSeedDto -> {
                    Part part = modelMapper.map(partSeedDto, Part.class);
                    part.setSupplier(supplierService.findRandomSupplier());
                    return part;
                })
                .forEach(partRepository::save);
    }

    @Override
    public Set<Part> findRandomPart() {
        Set<Part> randomParts = new HashSet<>();

        int randomPartCount = ThreadLocalRandom
                .current().nextInt(3,5); //add between 3 and 5 random parts

        long totalPartsCount = partRepository.count();

        for (int i = 0; i < randomPartCount; i++) {
            long randomId = ThreadLocalRandom
                    .current().nextLong(1, totalPartsCount + 1);
            randomParts.add(partRepository.findById(randomId).orElse(null));
        }

        return randomParts;
    }
}
