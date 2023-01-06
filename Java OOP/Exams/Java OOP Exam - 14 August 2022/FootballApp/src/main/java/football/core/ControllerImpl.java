package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.*;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Map<String, Field> fields;

    public ControllerImpl() {
        this.supplements = new SupplementRepositoryImpl();
        this.fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.put(fieldName, field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        if (type.equals("Powdered")) {
            supplement = new Powdered();
        } else if (type.equals("Liquid")) {
            supplement = new Liquid();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplements.add(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = supplements.findByType(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Field field = fields.get(fieldName);
        field.addSupplement(supplement);

        supplements.remove(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        if (playerType.equals("Men")) {
            player = new Men(playerName, nationality, strength);
        } else if (playerType.equals("Women")) {
            player = new Women(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        //Women -> I can only play on ArtificialTurf!
        //Men -> I can only play on NaturalGrass!

        Field field = fields.get(fieldName);
        String fieldType = field.getClass().getSimpleName();

        boolean areMenAndFieldSuitable = playerType.equals("Men") && fieldType.equals("NaturalGrass");
        boolean areWomenAndFieldSuitable = playerType.equals("Women") && fieldType.equals("ArtificialTurf");

        if (areMenAndFieldSuitable || areWomenAndFieldSuitable) {
            field.addPlayer(player);
        } else {
            return FIELD_NOT_SUITABLE;
        }

        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);

    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = fields.get(fieldName);
        field.drag();

        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.get(fieldName);
        Collection<Player> players = fields.get(fieldName).getPlayers();

        int calculatedStrength = players.stream().mapToInt(Player::getStrength).sum();
        //int calculatedStrength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();!!!

        return String.format(STRENGTH_FIELD, fieldName, calculatedStrength);
    }

    @Override
    public String getStatistics() {

        return fields.values().stream()
                .map(Field::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
