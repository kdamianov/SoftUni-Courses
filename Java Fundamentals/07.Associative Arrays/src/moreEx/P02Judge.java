package moreEx;

import java.util.*;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> contestInfoMap = new LinkedHashMap<>();

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("no more time")) {
            //"{username} -> {contest} -> {points}"
            String username = inputLine.split(" -> ")[0];
            String contest = inputLine.split(" -> ")[1];
            int points = Integer.parseInt(inputLine.split(" -> ")[2]);
            String pointsToAdd = String.valueOf(points);

            if (!contestInfoMap.containsKey(contest)) {
                contestInfoMap.put(contest, new ArrayList<>());
                contestInfoMap.get(contest).add(username);
                contestInfoMap.get(contest).add(pointsToAdd);
            } else {
                if (contestInfoMap.get(contest).contains(username)) {
                    int currentPoints = Integer.parseInt(contestInfoMap.get(contest).get(0));
                    if (currentPoints < points) {
                        contestInfoMap.get(contest).set(1, pointsToAdd);
                    }
                } else {
                    contestInfoMap.get(contest).add(username);
                    contestInfoMap.get(contest).add(pointsToAdd);
                }
            }

            inputLine = scanner.nextLine();
        }
        System.out.printf("");
    }
}
