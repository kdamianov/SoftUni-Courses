package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportDto;
import softuni.exam.models.dto.ForecastImportWrapperDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.models.Constants.*;

@Service
public class ForecastServiceImpl implements ForecastService {
    private static String FORECASTS_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository,
                               CityRepository cityRepository,
                               ValidationUtils validationUtils,
                               ModelMapper modelMapper,
                               XmlParser xmlParser) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        final StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(Path.of(FORECASTS_FILE_PATH).toFile(),
                        ForecastImportWrapperDto.class).getForecasts()
                .stream()
                .filter(forecastImportDto -> {
                    boolean isValid = validationUtils.isValid(forecastImportDto);
                    City city = cityRepository.findById(forecastImportDto.getCity()).orElse(null);
                    if (city == null) {
                        isValid = false;
                    }

                    Forecast forecastByCityAndDayOfWeek = forecastRepository.findForecastByCityAndDayOfWeek(city,
                            forecastImportDto.getDayOfWeek()).orElse(null);

                    if (forecastByCityAndDayOfWeek != null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid
                                    ? String.format("Successfully import forecast %s - %.2f",
                                    forecastImportDto.getDayOfWeek().toString(), forecastImportDto.getMaxTemperature())
                                    : "Invalid forecast")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(forecastImportDto -> {
                    Forecast forecast = modelMapper.map(forecastImportDto, Forecast.class);
                    City city = cityRepository.findById(forecastImportDto.getCity()).orElse(null);

                    forecast.setCity(city);

                    return forecast;
                })
                .forEach(forecastRepository::save);


        return sb.toString().trim();
    }

    @Override
    public String exportForecasts() {
        final StringBuilder sb = new StringBuilder();

        Set<Forecast> allBySunday = forecastRepository.findAllByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek.SUNDAY, 150000);

        allBySunday
                .forEach(forecast -> {
                    sb.append(String.format("City: %s\n" +
                                            "-min temperature: %.2f\n" +
                                            "--max temperature: %.2f\n" +
                                            "---sunrise: %s\n" +
                                            "-----sunset: %s",
                                    forecast.getCity().getCityName(),
                                    forecast.getMinTemperature(),
                                    forecast.getMaxTemperature(),
                                    forecast.getSunrise(),
                                    forecast.getSunset()))
                            .append(System.lineSeparator());
                });
        return sb.toString().trim();
    }
}
