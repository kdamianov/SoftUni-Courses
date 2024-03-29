package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number; //table number
    private int size; //table size
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople; //price for all people

    public BaseTable(int number, int size, double pricePerPerson) {
        this.setNumber(number);
        this.setSize(size);
        this.setPricePerPerson(pricePerPerson);
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    protected void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return size;
    }

    protected void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    protected void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) { //модифицира броят на хората, които искат маса, а не setter!
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double foodBill = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double beveragesBill = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();

        return foodBill + beveragesBill + (numberOfPeople * pricePerPerson);
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        isReservedTable = false;
        this.numberOfPeople = 0;


    }

    @Override
    public String tableInformation() {
        return String.format(
                "Table - %d%n" +
                "Size - %d%n " +
                "Type - %s%n" +
                "All price - %.2f"
                , number, size, this.getClass().getSimpleName(), pricePerPerson);
    }
}
