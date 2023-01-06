package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private HelperRepository<Helper> helperRepository;
    private PresentRepository<Present> presentRepository;
    private int craftedPresents = 0;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository<>();
        this.presentRepository = new PresentRepository<>();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        //списък с годни помощници
        Helper validHelper = helperRepository
                .getModels().stream()
                .filter(helper -> helper.getEnergy() > 50)
                .findFirst()
                .orElse(null);

        if (validHelper == null) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }
        //старт изработка
        Shop shop = new ShopImpl();
        Present presentToCraft = presentRepository.findByName(presentName);
        shop.craft(presentToCraft, validHelper);

        long brokenInstruments = validHelper
                .getInstruments()
                .stream()
                .filter(i -> i.getPower() == 0)
                .count();

        craftedPresents++;

        String present = presentToCraft.isDone()
                ? String.format(PRESENT_DONE, presentName, "done")
                : String.format(PRESENT_DONE, presentName, "not done");

        return present + String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(craftedPresents).append(" presents are done!").append(System.lineSeparator())
                .append("Helpers info:").append(System.lineSeparator());
        helperRepository
                .getModels()
                .forEach(h -> sb.append(String.format("Name: %s%nEnergy: %d%nInstruments: %d not broken left%n",
                        h.getName(), h.getEnergy(),
                        h.getInstruments().stream().filter(i -> i.getPower() !=0).count())));
        //да се намерят инструменти с energy > 0

        return sb.toString().trim();

    }
}
