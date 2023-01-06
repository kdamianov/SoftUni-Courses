package exercise.vehicles_extended;

public class Bus extends Vehicle{
    public static final double AC_ADDITIONAL_CONSUMPTION = 1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        setFuelConsumption(getFuelConsumption() + AC_ADDITIONAL_CONSUMPTION);
        String driveResults =  super.drive(distance);
        setFuelConsumption(getFuelConsumption() - AC_ADDITIONAL_CONSUMPTION);
        return driveResults;
    }

    public String driveEmpty(double distance){

        return super.drive(distance);
    }
}
