package FE05ProgrammingFundamentalsFinalExam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//100/100 в Judge

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern numberPattern = Pattern.compile("[0-9]");
        Matcher numberMatcher = numberPattern.matcher(text);
        long coolThreshold = 1L;
        List<String> emojiList = new ArrayList<>();

        while(numberMatcher.find()){
            int number = Integer.parseInt(numberMatcher.group());
            coolThreshold *= number;
        }
        System.out.println("Cool threshold: " + coolThreshold);

        Pattern emojiPattern = Pattern.compile("(:{2}|\\*{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher emojiMatcher = emojiPattern.matcher(text);

        List <String> coolEmojis = new ArrayList<>();
        while (emojiMatcher.find()) {
            String emoji = emojiMatcher.group("emoji");
            emojiList.add(emoji);
            long emojiCoolness = 0L;
            for (Character symbol : emoji.toCharArray()){
                emojiCoolness += symbol;
            }
            if (emojiCoolness > coolThreshold) {
                coolEmojis.add(emojiMatcher.group());
            }
        }
        System.out.printf("%s emojis found in the text. The cool ones are:%n", emojiList.size());
        coolEmojis.forEach(emoji -> System.out.println(emoji));

    }
}
