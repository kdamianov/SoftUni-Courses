package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopImportDto;
import exam.model.entity.Laptop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static exam.model.Constants.*;

@Service
public class LaptopServiceImpl implements LaptopService {
    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";
    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;
    private final Gson gson;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;

    public LaptopServiceImpl(LaptopRepository laptopRepository,
                             ShopRepository shopRepository,
                             Gson gson,
                             ValidationUtils validationUtils,
                             ModelMapper modelMapper) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(gson.fromJson(readLaptopsFileContent(), LaptopImportDto[].class))
                .filter(laptopImportDto -> {
                    boolean isValid = validationUtils.isValid(laptopImportDto);
                    boolean isLaptopPresent = laptopRepository.findByMacAddress(laptopImportDto.getMacAddress())
                            .isPresent();

                    if (isLaptopPresent) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_LAPTOPS, LAPTOP,
                                    laptopImportDto.getMacAddress(),
                                    laptopImportDto.getCpuSpeed(),
                                    laptopImportDto.getRam(),
                                    laptopImportDto.getStorage())
                                    : String.format(INVALID_FORMAT, LAPTOP))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(laptopImportDto -> {
                    Laptop laptop = modelMapper.map(laptopImportDto, Laptop.class);
                    laptop.setShop(shopRepository.findByName(laptopImportDto.getShop().getName()).orElse(null));
                    return laptop;
                })
                .forEach(laptopRepository::save);


        return sb.toString().trim();
    }

    @Override
    public String exportBestLaptops() {
        final StringBuilder sb = new StringBuilder();
        List<Laptop> bestLaptops = laptopRepository.findBestLaptops();

                bestLaptops
                .forEach(laptop -> sb.append(String.format(
                        "Laptop - %s%n" +
                                "*Cpu speed - %.2f%n" +
                                "**Ram - %d%n" +
                                "***Storage - %d%n" +
                                "****Price - %.2f%n" +
                                "#Shop name - %s%n" +
                                "##Town - %s%n",
                        laptop.getMacAddress(),
                        laptop.getCpuSpeed(),
                        laptop.getRam(),
                        laptop.getStorage(),
                        laptop.getPrice(),
                        laptop.getShop().getName(),
                        laptop.getShop().getTown().getName()
                )).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
