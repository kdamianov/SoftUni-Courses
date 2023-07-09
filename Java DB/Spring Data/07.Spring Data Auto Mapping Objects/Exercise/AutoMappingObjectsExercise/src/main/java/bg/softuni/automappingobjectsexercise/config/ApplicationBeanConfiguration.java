package bg.softuni.automappingobjectsexercise.config;

import bg.softuni.automappingobjectsexercise.model.dto.GameAddDto;
import bg.softuni.automappingobjectsexercise.model.entities.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration //задължителна анотация!!!!
public class ApplicationBeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //правим настройка на Mapper-а,
        // за да конвертира правилно информацията, ако има разминаваме в Entity и DTO (типове данни или имена на properties)
        modelMapper.typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper ->
                        mapper.map(GameAddDto::getThumbnailURL,
                                Game::setImageThumbnail));

        //Конвертор за данни (String -> LocalDate)
        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        };
        //Добавяме конвертора в mapper-a, за да е валиден иначе няма да съществува
        modelMapper.addConverter(localDateConverter);
        return modelMapper;
    }
}
