package bg.softuni.planer_app.init;

import bg.softuni.planer_app.service.impl.PriorityServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final PriorityServiceImpl priorityServiceImpl;

    public DBInit(PriorityServiceImpl priorityServiceImpl) {
        this.priorityServiceImpl = priorityServiceImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        this.priorityServiceImpl.priorityInit();
    }
}
