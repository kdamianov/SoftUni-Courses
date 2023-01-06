package P04RawDataExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tyre1pressure = Double.parseDouble(data[5]);
            int tyre1age = Integer.parseInt(data[6]);
            double tyre2pressure = Double.parseDouble(data[7]);
            int tyre2age = Integer.parseInt(data[8]);
            double tyre3pressure = Double.parseDouble(data[9]);
            int tyre3age = Integer.parseInt(data[10]);
            double tyre4pressure = Double.parseDouble(data[11]);
            int tyre4age = Integer.parseInt(data[12]);

            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Engine engine = new Engine(engineSpeed, enginePower);
            Tyre tyre1 = new Tyre(tyre1pressure, tyre1age);
            Tyre tyre2 = new Tyre(tyre2pressure, tyre2age);
            Tyre tyre3 = new Tyre(tyre3pressure, tyre3age);
            Tyre tyre4 = new Tyre(tyre4pressure, tyre4age);

            List<Tyre> tyres = new ArrayList<>();
            tyres.add(tyre1);
            tyres.add(tyre2);
            tyres.add(tyre3);
            tyres.add(tyre4);

            Car car = new Car(model, engine, cargo, tyres);

            carList.add(car);

        }
        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                carList.stream()
                        .filter(c -> c.getCargo().getType().equals("fragile"))
                        .filter(c -> c.getTyres().stream().anyMatch(t -> t.getTyrePressure() < 1))
                        .forEach(car -> System.out.println(car.getModel()));
                break;
            case "flamable":
                carList.stream()
                        .filter(c -> c.getCargo().getType().equals("flamable"))
                        .filter(c -> c.getEngine().getPower() > 250)
                        .forEach(car -> System.out.println(car.getModel()));
                break;
        }
    }
}
