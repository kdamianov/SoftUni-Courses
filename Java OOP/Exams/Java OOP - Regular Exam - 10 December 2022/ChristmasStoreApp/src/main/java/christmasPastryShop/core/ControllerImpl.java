package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.BoothRepositoryImpl;
import christmasPastryShop.repositories.CocktailRepositoryImpl;
import christmasPastryShop.repositories.DelicacyRepositoryImpl;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.*;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalMoney;


    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = type.equals("Gingerbread")
                ? new Gingerbread(name, price)
                : new Stolen(name, price);

        if (delicacyRepository.getByName(name) == null) {
            this.delicacyRepository.add(delicacy);
            return String.format(DELICACY_ADDED, name, type);
        } else {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = type.equals("MulledWine")
                ? new MulledWine(name, size, brand)
                : new Hibernation(name, size, brand);

        if (cocktailRepository.getByName(name) == null) {
            this.cocktailRepository.add(cocktail);
            return String.format(COCKTAIL_ADDED, name, brand);
        } else {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = type.equals("OpenBooth")
                ? new OpenBooth(boothNumber, capacity)
                : new PrivateBooth(boothNumber, capacity);


        if (boothRepository.getByNumber(boothNumber) == null) {
            this.boothRepository.add(booth);
            return String.format(BOOTH_ADDED, boothNumber);
        } else {
            throw new  IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Collection<Booth> booths = this.boothRepository.getAll();

        Booth freeBooth = booths.stream()
                .filter(b -> !b.isReserved() && b.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);


        if (freeBooth == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            freeBooth.reserve(numberOfPeople);
            return String.format(BOOTH_RESERVED, freeBooth.getBoothNumber(), numberOfPeople);
        }

    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);

        double bill = booth.getBill();

        totalMoney += bill;

        booth.clear();

        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {;
        return String.format(TOTAL_INCOME, totalMoney);
    }
}
