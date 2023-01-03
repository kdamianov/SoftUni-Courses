package moreExercise;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int doctors = 7;
        int treatedPats = 0;
        int untreatedPats = 0;


        for (int i = 1; i <= n; i++) {

            int patients = Integer.parseInt(scanner.nextLine());

            if (i % 3 ==0 && untreatedPats > treatedPats) {
                doctors = doctors +1;
            }

            if (doctors >= patients) {
                treatedPats += patients;

            } else {
                treatedPats += doctors;
                untreatedPats += patients - doctors;

                }
            }
        System.out.printf("Treated patients: %d.%n", treatedPats);
        System.out.printf("Untreated patients: %d.", untreatedPats);
        }
    }

