package FE01ProgrammingFundamentalsFinalExamRetake;

import java.util.*;
//100/100 в JUDGE!!!

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> map = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            //"{piece}|{composer}|{key}".
            String[] inputData = input.split("\\|");
            String piece = inputData[0];
            String composer = inputData[1];
            String key = inputData[2];

            map.put(piece, new ArrayList<>());
            map.get(piece).add(composer);
            map.get(piece).add(key);
        }
        String secondInput = scanner.nextLine();

        while (!secondInput.equals("Stop")){
            String[] secondInputData = secondInput.split("\\|");
            String command = secondInputData[0];
            String pieceToProcess = secondInputData[1];
            if(command.contains("Add")) {
                //Add|{piece}|{composer}|{key}":
                String composerToAdd = secondInputData[2];
                String keyToAdd = secondInputData[3];
                if (!map.containsKey(pieceToProcess)) {
                    map.put(pieceToProcess, new ArrayList<>());
                    map.get(pieceToProcess).add(composerToAdd);
                    map.get(pieceToProcess).add(keyToAdd);
                    System.out.printf("%s by %s in %s added to the collection!%n",
                            pieceToProcess, composerToAdd, keyToAdd);

                } else {
                    System.out.printf("%s is already in the collection!%n", pieceToProcess);
                }
            } else if (command.contains("Remove")) {
            //Remove|{piece}":
                if (map.containsKey(pieceToProcess)) {
                    map.remove(pieceToProcess);
                    System.out.printf("Successfully removed %s!%n", pieceToProcess);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceToProcess);
                }
            }else if (command.contains("ChangeKey")) {
            //"ChangeKey|{piece}|{new key}":
                String keyToChange = secondInputData[2];
                if (map.containsKey(pieceToProcess)) {
                    map.get(pieceToProcess).set(1, keyToChange);
                    System.out.printf("Changed the key of %s to %s!%n", pieceToProcess, keyToChange);
                }else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n",
                            pieceToProcess);
                }
            }
            secondInput = scanner.nextLine();
        }
        //"{Piece} -> Composer: {composer}, Key: {key}"
        map.entrySet().forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
