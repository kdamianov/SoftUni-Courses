package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static softuni.exam.models.Constants.*;

@Service
public class CityServiceImpl implements CityService {
    private static String CITIES_FILE_PATH = "src/main/resources/files/json/cities.json";
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository,
                           CountryRepository countryRepository,
                           ValidationUtils validationUtils,
                           ModelMapper modelMapper,
                           Gson gson) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        final StringBuilder sb = new StringBuilder();

        CityImportDto[] cityImportDtos = gson.fromJson(readCitiesFileContent(), CityImportDto[].class);

        for (CityImportDto cityImportDto : cityImportDtos) {
            sb.append(System.lineSeparator());

            if (this.cityRepository.findCityByCityName(cityImportDto.getCityName()).isPresent() ||
                    !validationUtils.isValid(cityImportDto)) {
                sb.append(String.format(INVALID_FORMAT, CITY));
                continue;
            };

            City city = modelMapper.map(cityImportDto, City.class);
            Optional<Country> country = countryRepository.findById(cityImportDto.getCountry());
            city.setCountry(country.get());
            cityRepository.save(city);
            sb.append(String.format(SUCCESSFUL_FORMAT, CITY,
                    cityImportDto.getCityName(), cityImportDto.getPopulation()));
        }

        return sb.toString().trim();
    }
}
