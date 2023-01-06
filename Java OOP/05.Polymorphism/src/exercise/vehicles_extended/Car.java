package exercise.vehicles_extended;

public class Car extends Vehicle {
    public final static double AC_ADDITIONAL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setFuelConsumption(fuelConsumption + AC_ADDITIONAL_CONSUMPTION);
    }



}
