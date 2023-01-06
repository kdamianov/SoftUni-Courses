package exercise.vehicles_extended;

public class Truck extends Vehicle {
    public final static double AC_ADDITIONAL_CONSUMPTION = 1.6;
    public final static double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setFuelConsumption(fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres * FUEL_AFTER_DRIVER_DEDUCTION);
    }



}
