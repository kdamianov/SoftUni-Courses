package exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();
        List<String> racersNames =  Arrays.stream(names.split(", ")).collect(Collectors.toList());
        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        racersNames.forEach(name -> racersDistances.put(name, 0));

        //regex
        String regexLetter = "[A-Za-z]+";
        Pattern patternLetter = Pattern.compile(regexLetter);

        String regexDigit = "[0-9]";
        Pattern patternDigit = Pattern.compile(regexDigit);

        String input = scanner.nextLine();
        while(!input.equals("end of race")) {
        //input  = "G!32e%o7r#32g$235@!2e"
        //name - само от буквите в input
            StringBuilder nameBuilder = new StringBuilder();
            Matcher matcherLetter = patternLetter.matcher(input);//всички букви
            while (matcherLetter.find()){
                nameBuilder.append(matcherLetter.group());
            }
        //distance - сума от цифрите в input
            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input); //всички цифри
            while (matcherDigit.find()) {
                distance += Integer.parseInt(matcherDigit.group());
            }

            //добавя се дистанцията на определения състезател
            String racerName = nameBuilder.toString();
            if (racersDistances.containsKey(racerName)) {
                int currentDistance = racersDistances.get(racerName);
                racersDistances.put(racerName, currentDistance + distance);
            }

            input = scanner.nextLine();
        }
        //състезател -> дистанция
        List<String> nameOfFirstThree = racersDistances.entrySet().stream() //взимаме Map-а, за да го преобразуваме
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) //подрежда по низходящ ред на дистанцията
                .limit(3) //взима 1те 3 записа само
                .map(entry -> entry.getKey()) //вземаме на всеки запис ключа //.map(Map.Entry::getKey)
                .collect(Collectors.toList()); //правим го на List

        System.out.println("1st place: " + nameOfFirstThree.get(0));
        System.out.println("2nd place: " + nameOfFirstThree.get(1));
        System.out.println("3rd place: " + nameOfFirstThree.get(2));
    }
}
