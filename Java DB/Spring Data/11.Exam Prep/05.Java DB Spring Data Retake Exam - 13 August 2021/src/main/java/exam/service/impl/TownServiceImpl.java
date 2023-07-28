package exam.service.impl;

import exam.model.dto.TownImportDto;
import exam.model.dto.TownImportWrapperDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtils;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static exam.model.Constants.*;

@Service
public class TownServiceImpl implements TownService {
    private static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";
    private final TownRepository townRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public TownServiceImpl(TownRepository townRepository,
                           ValidationUtils validationUtils,
                           ModelMapper modelMapper, XmlParser xmlParser) {
        this.townRepository = townRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        final StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(Path.of(TOWNS_FILE_PATH).toFile(), TownImportWrapperDto.class)
                .getTowns()
                .stream()
                .filter(townImportDto -> {
                    boolean isValid = validationUtils.isValid(townImportDto);

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_TOWNS, TOWN,
                                    townImportDto.getName())
                                    : String.format(INVALID_FORMAT, TOWN))
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(townImportDto -> modelMapper.map(townImportDto, Town.class))
                .forEach(townRepository::save);

        return sb.toString().trim();
    }
}
