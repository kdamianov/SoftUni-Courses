package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentImportWrapperDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static softuni.exam.models.Constants.*;

@Service

public class ApartmentServiceImpl implements ApartmentService {
    private static final String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;
    private final XmlParser xmlParser;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository,
                                TownRepository townRepository,
                                ModelMapper modelMapper,
                                ValidationUtils validationUtils,
                                XmlParser xmlParser) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        final StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(Path.of(APARTMENTS_FILE_PATH).toFile(), ApartmentImportWrapperDto.class)
                .getApartments()
                .stream()
                .filter(apartmentImportDto -> {
                    boolean isValid = validationUtils.isValid(apartmentImportDto);

                    boolean isPresent = apartmentRepository
                            .findByTownAndArea(townRepository.findByTownName(apartmentImportDto.getTown())
                                            .orElse(null),
                                    apartmentImportDto.getArea()).isPresent();

                    if (isPresent) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_APARTMENTS, APARTMENT,
                                    apartmentImportDto.getApartmentType(), apartmentImportDto.getArea())
                                    : String.format(INVALID_FORMAT, APARTMENT))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(apartmentImportDto -> {
                    Apartment apartment = modelMapper.map(apartmentImportDto, Apartment.class);
                    Town town = townRepository.findByTownName(apartmentImportDto.getTown()).orElse(null);
                    apartment.setTown(town);
                    return apartment;
                })
                .forEach(apartmentRepository::save);

        return sb.toString().trim();
    }
}
