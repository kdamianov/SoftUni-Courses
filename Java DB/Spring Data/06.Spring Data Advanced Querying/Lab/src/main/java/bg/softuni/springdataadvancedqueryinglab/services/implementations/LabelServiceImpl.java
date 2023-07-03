package bg.softuni.springdataadvancedqueryinglab.services.implementations;

import bg.softuni.springdataadvancedqueryinglab.repositories.LabelRepository;
import bg.softuni.springdataadvancedqueryinglab.services.LabelService;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {
    private LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }
}
