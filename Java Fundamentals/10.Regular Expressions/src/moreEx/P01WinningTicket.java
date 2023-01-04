package moreEx;

import java.util.*;
import java.util.stream.Collectors;

public class P01WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> ticketsList = Arrays.stream(input.split(", ")).collect(Collectors.toList());

    }
}
