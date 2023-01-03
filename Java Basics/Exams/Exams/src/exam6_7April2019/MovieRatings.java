package exam6_7April2019;

import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numMovies = Integer.parseInt(scanner.nextLine());

        double maxRating = Double.MIN_VALUE;
        double minRating = Double.MAX_VALUE;
        String highRatingMovie = "";
        String lowRatingMovie = "";
        double sum = 0;

        for (int i = 1; i <= numMovies ; i++) {
            String movieName = scanner.nextLine();
            double rating = Double.parseDouble(scanner.nextLine());


            if (rating > maxRating) {
                maxRating = rating;
                highRatingMovie = movieName;
            }
            if (rating < minRating) {
                minRating = rating;
                lowRatingMovie = movieName;
            }
            sum += rating;
        }
        System.out.printf("%s is with highest rating: %.1f%n", highRatingMovie, maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n", lowRatingMovie, minRating);
        System.out.printf("Average rating: %.1f", sum / numMovies);
    }
}
