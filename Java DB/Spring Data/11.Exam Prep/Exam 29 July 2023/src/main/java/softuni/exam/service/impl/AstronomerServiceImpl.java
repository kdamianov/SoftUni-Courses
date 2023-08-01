package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportWrapperDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.models.Constants.*;

@Service
public class AstronomerServiceImpl implements AstronomerService {
    private static final String ASTRONOMERS_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";
    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final ValidationUtils validationUtils;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository,
                                 StarRepository starRepository,
                                 ValidationUtils validationUtils,
                                 XmlParser xmlParser,
                                 ModelMapper modelMapper) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        final StringBuilder sb = new StringBuilder();

        this.xmlParser.fromFile(Path.of(ASTRONOMERS_FILE_PATH).toFile(), AstronomerImportWrapperDto.class)
                .getAstronomers()
                .stream()
                .filter(astronomerImportDto -> {
                    boolean isValid = this.validationUtils.isValid(astronomerImportDto);

                    boolean isAstronomerPresent = this.astronomerRepository
                            .findByFirstNameAndLastName(astronomerImportDto.getFirstName(), astronomerImportDto
                                    .getLastName()).isPresent();

                    if (isAstronomerPresent) {
                        isValid = false;
                    }

                    boolean isStarEmpty = this.starRepository
                            .findById(astronomerImportDto.getObservingStarId()).isEmpty();

                    if (isStarEmpty) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_ASTRONOMERS, ASTRONOMER,
                                    astronomerImportDto.getFirstName(),
                                    astronomerImportDto.getLastName(),
                                    astronomerImportDto.getAverageObservationHours())
                                    : String.format(INVALID_FORMAT, ASTRONOMER))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(astronomerImportDto -> {
                    Astronomer astronomer = this.modelMapper.map(astronomerImportDto, Astronomer.class);
                    astronomer.setObservingStar(starRepository.findById(astronomerImportDto.getObservingStarId())
                            .orElse(null));

                    return astronomer;
                })
                .forEach(astronomerRepository::save);

        return sb.toString().trim();
    }
}
