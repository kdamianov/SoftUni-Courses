package exercise.vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    public final static double AC_ADDITIONAL_CONSUMPTION = 1.6;
    public final static double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        setFuelConsumption(fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres * FUEL_AFTER_DRIVER_DEDUCTION);
    }



}
