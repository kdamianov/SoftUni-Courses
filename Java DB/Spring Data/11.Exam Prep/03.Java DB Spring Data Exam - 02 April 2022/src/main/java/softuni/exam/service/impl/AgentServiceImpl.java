package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.models.Constants.*;

@Service
public class AgentServiceImpl implements AgentService {
    private static final String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;
    private final Gson gson;

    public AgentServiceImpl(AgentRepository agentRepository,
                            TownRepository townRepository,
                            ModelMapper modelMapper,
                            ValidationUtils validationUtils,
                            Gson gson) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson
                        .fromJson(readAgentsFromFile(), AgentImportDto[].class))
                .filter(agentImportDto -> {
                    boolean isValid = validationUtils.isValid(agentImportDto);

                    Agent agentByFirstName = agentRepository.findByFirstName(agentImportDto.getFirstName()).orElse(null);
                    if (agentByFirstName != null) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format(SUCCESSFUL_FORMAT_AGENTS, AGENT, agentImportDto.getFirstName(), agentImportDto.getLastName())
                                    : String.format(INVALID_FORMAT, AGENT))
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(agentImportDto -> {
                    Agent agent = modelMapper.map(agentImportDto, Agent.class);
                    agent.setTown(townRepository.findByTownName(agentImportDto.getTown()).orElse(null));
                    return agent;
                })
                .forEach(agentRepository::save);
        return sb.toString().trim();
    }
}
