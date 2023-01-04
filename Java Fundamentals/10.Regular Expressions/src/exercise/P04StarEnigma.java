package exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countMessage = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldiersCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> attackedPlanets = new ArrayList<>(); //атакувани планети -> attackType = "A";
        List<String> destroyedPlanets = new ArrayList<>(); //унищожени планети -> attackType = "D";

        for (int messageCount = 1; messageCount <= countMessage; messageCount++) {
            String encryptedMessage = scanner.nextLine(); //криптирано съобщение
            String decryptedMessage = getDecryptedMessage(encryptedMessage);
        //@{planetName}:{population}!{attackType}!->{soldiersCount} - Информация за планетата!
        //декриптирано съобщение: "PQ@Alderaa1:30000!A!->20000"
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                //int population = Integer.parseInt(matcher.group("population"));
                String attackType = matcher.group("attackType");
                //int soldiersCount = Integer.parseInt(matcher.group("soldiersCount"));

                if (attackType.equals("A")) {
                    attackedPlanets.add(planetName);
                } else if (attackType.equals("D")){
                    destroyedPlanets.add(planetName);
                }
            }
        }
        System.out.printf("Attacked planets: %s%n", attackedPlanets.size());
        Collections.sort(attackedPlanets);
        attackedPlanets.forEach(planet -> System.out.printf("-> %s%n", planet));
        System.out.printf("Destroyed planets: %s%n", destroyedPlanets.size());
        Collections.sort(destroyedPlanets);
        destroyedPlanets.forEach(planet -> System.out.printf("-> %s%n", planet));
    }

    //връща декриптирано съобщение
    private static String getDecryptedMessage(String encryptedMessage) {
        //1. брой на s,t,a,r - case sensitive (s,t,a,r,S,T,A,R)
        int countLetters = getSpecialLettersCount(encryptedMessage);

        //декриптиране -> констриураме ново съобщение
        StringBuilder decryptedMessage = new StringBuilder();
        //символ = текущ ASCII код - countLetters
        for (char symbol: encryptedMessage.toCharArray()) {
            char newSymbol = (char) (symbol - countLetters);
            decryptedMessage.append(newSymbol);
        }
        return decryptedMessage.toString();
    }

    //връща общ брой на буквите (s,t,a,r,S,T,A,R)
    private static int getSpecialLettersCount(String encryptedMessage) {
        int count = 0;
        for (char symbol : encryptedMessage.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count ++;
                    break;

            }
        }
        return count;
    }
}
