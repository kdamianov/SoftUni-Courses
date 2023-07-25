package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskExportDto;
import softuni.exam.models.dto.TaskImportDto;
import softuni.exam.models.dto.TaskWrapperDto;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private final TasksRepository tasksRepository;
    private final PartsRepository partsRepository;
    private final MechanicsRepository mechanicsRepository;
    private final CarsRepository carsRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepository,
                            PartsRepository partsRepository,
                            MechanicsRepository mechanicsRepository,
                            CarsRepository carsRepository,
                            ValidationUtils validationUtils,
                            ModelMapper modelMapper,
                            XmlParser xmlParser) {
        this.tasksRepository = tasksRepository;
        this.partsRepository = partsRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.carsRepository = carsRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        final StringBuilder stringBuilder = new StringBuilder();
        final List<TaskImportDto> tasks = xmlParser
                .fromFile(Path.of(TASKS_FILE_PATH).toFile(), TaskWrapperDto.class)
                .getTasks();

        for (TaskImportDto task : tasks) {
            stringBuilder.append(System.lineSeparator());

            if (this.validationUtils.isValid(task)) {
                final Optional<Car> car = this.carsRepository
                        .findById(task.getCar().getId());
                final Optional<Mechanic> mechanic = this.mechanicsRepository
                        .findFirstByFirstName(task.getMechanic().getFirstName());
                final Optional<Part> part = this.partsRepository
                        .findById(task.getPart().getId());

                if (car.isEmpty() || mechanic.isEmpty() || part.isEmpty()) {
                    stringBuilder.append(String.format(INVALID_FORMAT, TASK));
                    continue;
                }

                Task taskToSave = this.modelMapper.map(task, Task.class);
                taskToSave.setCar(car.get());
                taskToSave.setMechanic(mechanic.get());
                taskToSave.setPart(part.get());

                this.tasksRepository.save(taskToSave);
                stringBuilder.append(String.format(SUCCESSFUL_FORMAT,
                        TASK,
                        task.getPrice().setScale(2), "").trim());
                continue;
            }

            stringBuilder.append(String.format(INVALID_FORMAT, TASK));
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        return this.tasksRepository.findAllByCar_CarTypeOrderByPriceDesc(CarType.coupe)
                .stream()
                .map(task -> modelMapper.map(task, TaskExportDto.class))
                .map(TaskExportDto::toString)
                .collect(Collectors.joining())
                .trim();
    }
}
