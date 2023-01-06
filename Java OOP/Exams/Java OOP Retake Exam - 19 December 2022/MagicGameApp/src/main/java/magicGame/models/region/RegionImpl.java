package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {

        List<Magician> wizards = magicians.stream()
                .filter(m -> m instanceof Wizard)
                .collect(Collectors.toList());
        List<Magician> blackWidows = magicians.stream()
                .filter(m -> m instanceof BlackWidow)
                .collect(Collectors.toList());

        while (wizards.stream().anyMatch(w -> w.getHealth() > 0)
                || blackWidows.stream().anyMatch(bw -> bw.getHealth() > 0)) {

            for (Magician wizard : wizards) {
                for (Magician blackWidow : blackWidows) {
                    blackWidow.takeDamage(wizard.getMagic().fire());
                }
            }
            blackWidows = blackWidows.stream()
                    .filter(Magician::isAlive)
                    .collect(Collectors.toList());

            for (Magician blackWidow : blackWidows) {
                for (Magician wizard : wizards) {
                    wizard.takeDamage(blackWidow.getMagic().fire());
                }
            }

            wizards = wizards.stream()
                    .filter(Magician::isAlive)
                    .collect(Collectors.toList());

        }
        if (blackWidows.isEmpty()) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }

    }
}
