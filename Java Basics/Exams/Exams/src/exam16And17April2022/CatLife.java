package exam16And17April2022;

import java.util.Scanner;

public class CatLife {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String catBreed = scanner.nextLine();
        char catSex = scanner.next().charAt(0);
        double yearsInMothns = 0;
        double catMonths = 0;
        boolean isInvalid = false;

        switch (catBreed) {
            case "British Shorthair":
                if (catSex == 'm') {
                    yearsInMothns = 13 * 12;
                    catMonths = yearsInMothns / 6;
                } else if (catSex == 'f') {
                    yearsInMothns = 14 * 12;
                    catMonths = yearsInMothns / 6;
                }
                break;
            case "Siamese":
                if (catSex == 'm') {
                    yearsInMothns = 15 * 12;
                    catMonths = yearsInMothns / 6;
                } else if (catSex == 'f') {
                    yearsInMothns = 16 * 12;
                    catMonths = yearsInMothns / 6;
                }
                break;
            case "Persian":
                if (catSex == 'm') {
                    yearsInMothns = 14 * 12;
                    catMonths = yearsInMothns / 6;
                } else if (catSex == 'f') {
                    yearsInMothns = 15 * 12;
                    catMonths = yearsInMothns / 6;
                }
                break;
            case "Ragdoll":
                if (catSex == 'm') {
                    yearsInMothns = 16 * 12;
                    catMonths = yearsInMothns / 6;
                } else if (catSex == 'f') {
                    yearsInMothns = 17 * 12;
                    catMonths = yearsInMothns / 6;
                }
                break;
            case "American Shorthair":
                if (catSex == 'm') {
                    yearsInMothns = 12 * 12;
                    catMonths = yearsInMothns / 6;
                } else if (catSex == 'f') {
                    yearsInMothns = 13 * 12;
                    catMonths = yearsInMothns / 6;
                }
                break;
            case "Siberian":
                if (catSex == 'm') {
                    yearsInMothns = 11 * 12;
                    catMonths = yearsInMothns / 6;
                } else if (catSex == 'f') {
                    yearsInMothns = 12 * 12;
                    catMonths = yearsInMothns / 6;
                }
                break;
            default:
                isInvalid = true;
                break;
        }

        if (isInvalid) {
            System.out.printf("%s is invalid cat!", catBreed);
        } else {
            System.out.printf("%.0f cat months", Math.floor(catMonths));
        }
    }
}
