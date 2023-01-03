import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double fuelLitres = Double.parseDouble(scanner.nextLine());


        switch (fuelType) {
            case "Diesel":
                if (fuelLitres < 25) {
                    System.out.println("Fill your tank with diesel!");
                } else {
                    System.out.println("You have enough diesel.");
                }
                break;
            case "Gasoline":
                if (fuelLitres < 25) {
                    System.out.println("Fill your tank with gasoline!");
                } else {
                    System.out.println("You have enough gasoline.");
                }
                break;
            case "Gas":
                if (fuelLitres < 25) {
                    System.out.println("Fill your tank with gas!");
                } else {
                    System.out.println("You have enough gas.");
                }

                break;

            default:
                System.out.println("Invalid fuel!");
                break;
        }

    }

}
