package goldDigger.core;

import goldDigger.models.discoverer.*;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int inspectedSpots;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        inspectedSpots = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;

        if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals("Archaeologist")) {
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals("Geologist")) {
            discoverer = new Geologist(discovererName);
        } else {
            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }

        discovererRepository.add(discoverer);

        return String.format(DISCOVERER_ADDED, kind, discovererName);

    }

    @Override
    public String addSpot(String spotName, String... exhibitsToAdd) {
        Spot spot = new SpotImpl(spotName);

        for (String exhibitToAdd : exhibitsToAdd) {
            spot.getExhibits().add(exhibitToAdd);
        }
        spotRepository.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discovererToRemove = discovererRepository.byName(discovererName);
        if (discovererToRemove == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }

        discovererRepository.remove(discovererToRemove);

        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        //discoverers with energy > 45
        List<Discoverer> validDiscoverers = discovererRepository
                .getCollection()
                .stream()
                .filter(d -> d.getEnergy() > 45)
                .collect(Collectors.toList());
        //всички, които могат да продължат

        //if none -> Exception
        if (validDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        //StartOperation(){}
        Spot spotToExplore = spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spotToExplore, validDiscoverers);
        //count of discoverers with energy = 0
        long countOfExhaustedExplorers = validDiscoverers.stream().filter(discoverer -> discoverer.getEnergy() == 0).count();
        inspectedSpots++;

        return String.format(INSPECT_SPOT, spotName, countOfExhaustedExplorers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_SPOT_INSPECT, inspectedSpots))
                .append(System.lineSeparator())
                .append(FINAL_DISCOVERER_INFO)
                .append(System.lineSeparator());

        for (Discoverer discoverer : discovererRepository.getCollection()) {
            sb.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()))
                    .append(System.lineSeparator());
            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None"))
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                        String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits())))
                        .append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
