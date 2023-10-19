package bg.softuni.planer_app.service.impl;

import bg.softuni.planer_app.model.entity.PriorityEntity;
import bg.softuni.planer_app.model.enums.PriorityNameEnum;
import bg.softuni.planer_app.repo.PriorityRepository;
import bg.softuni.planer_app.service.PriorityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {
    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void priorityInit() {
        if (this.priorityRepository.count() != 0) {
            return;
        }

        List<PriorityEntity> priorities = new ArrayList<>();

        Arrays.stream(PriorityNameEnum.values())
                .forEach(priorityName -> {
                    PriorityEntity priorityEntity = new PriorityEntity();
                    priorityEntity.setName(priorityName);
                    priorities.add(priorityEntity);
                });

        priorityRepository.saveAll(priorities); //avoid N+1!
    }

}
