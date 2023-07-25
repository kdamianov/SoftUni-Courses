package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class CountryServiceImpl implements CountryService {
    private static String COUNTRIES_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository,
                              ValidationUtils validationUtils,
                              ModelMapper modelMapper,
                              Gson gson) {
        this.countryRepository = countryRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {

        return Files.readString(Path.of(COUNTRIES_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        final StringBuilder sb = new StringBuilder();

        CountryImportDto[] countryImportDtos = this.gson.fromJson(readCountriesFromFile(), CountryImportDto[].class);


        for (CountryImportDto countryImportDto : countryImportDtos) {
            sb.append(System.lineSeparator());

            if (this.countryRepository.findCountryByCountryName(countryImportDto.getCountryName()).isPresent() ||
                    !validationUtils.isValid(countryImportDto)) {
                sb.append(String.format(INVALID_FORMAT, COUNTRY));
                continue;
            };
            this.countryRepository.save(modelMapper.map(countryImportDto, Country.class));
            sb.append(String.format(SUCCESSFUL_FORMAT, COUNTRY,
                    countryImportDto.getCountryName(), countryImportDto.getCurrency()));
        }


        return sb.toString().trim();
    }
}
