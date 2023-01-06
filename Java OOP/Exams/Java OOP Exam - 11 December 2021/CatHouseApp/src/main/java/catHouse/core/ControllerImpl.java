package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toyRepository;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toyRepository = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        this.houses.add(house);

        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toyRepository.buyToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        if (toyRepository.findFirst(toyType) == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        Toy toy = toyRepository.findFirst(toyType);
        House house = getHouseByName(houseName);
        house.buyToy(toy);

        toyRepository.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;
        if (!catType.equals("ShorthairCat") && !catType.equals("LonghairCat")) {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
        }

        House house = getHouseByName(houseName);
        boolean isShort = house.getClass().getSimpleName().equals("ShortHouse") && catType.equals("ShorthairCat");
        boolean isLong = house.getClass().getSimpleName().equals("LongHouse") && catType.equals("LonghairCat");

        if (isShort || isLong) {
            house.addCat(cat);
        } else {
            return UNSUITABLE_HOUSE;
        }


        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = getHouseByName(houseName);
        house.feeding();

        return String.format(FEEDING_CAT, house.getCats().size());
    }

    private House getHouseByName(String houseName) {
        return houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().get();
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = getHouseByName(houseName);
        double totalCatPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double totalToyPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double totalSum = totalCatPrice + totalToyPrice;

        return String.format(VALUE_HOUSE, houseName, totalSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        houses.forEach(h -> sb.append(h.getStatistics()));

        return sb.toString().trim();
    }
}
