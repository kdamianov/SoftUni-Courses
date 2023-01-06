package P03SpeedRacingExercise;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumptionPerKm;
    private int travelledDistance;

    public Car(String model, double fuelAmount, double fuelConsumptionPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.travelledDistance = 0;
    }
    public double calculateRequiredFuel(int distance){
        return this.getFuelConsumptionPerKm() * distance;
    }
    public boolean hasEnoughFuel(int distance) {
        return fuelAmount >= calculateRequiredFuel(distance);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void drive (int distance) {
        if (hasEnoughFuel(distance)) {
            this.fuelAmount -= calculateRequiredFuel(distance);
            this.travelledDistance += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(int travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, travelledDistance);
    }


}
