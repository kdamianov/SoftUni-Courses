package finalExamPrep01;

import java.util.*;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();
        int countPieces = Integer.parseInt(scanner.nextLine());

        //информация за всяка една пиеса
        //пиеса -> списък с инфо (композитор, тоналност)

        for (int i = 1; i <= countPieces; i++) {
            String pieceData = scanner.nextLine();
            //[0]"{piece}|[1]{composer}|[2]{key}".

            String[] pieceParts = pieceData.split("\\|");
            String pieceName = pieceParts[0];
            String composer = pieceParts[1];
            String tone = pieceParts[2];

            List<String> pieceInfo = new ArrayList<>();
            pieceInfo.add(composer);
            pieceInfo.add(tone);

            piecesMap.put(pieceName, pieceInfo);
        }
        //команди
        String command = scanner.nextLine();

        while(!command.equals("Stop")) {

            if (command.contains("Add")){
            //1."[0]Add|[1]{piece}|[2]{composer}|[3]{key}":
                String pieceName = command.split("\\|")[1];
                String composer = command.split("\\|")[2];
                String tone = command.split("\\|")[3];
                //има такава пиеса
                if (piecesMap.containsKey(pieceName)) {
                    System.out.printf("%s is already in the collection!%n", pieceName);
                }else{
                    List<String> info  = new ArrayList<>();
                    info.add(composer);
                    info.add(tone);

                    piecesMap.put(pieceName, info);
                    System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, tone);
                }
            }else if (command.contains("Remove")) {
             //2."Remove|{piece}":
                String removedPiece = command.split("\\|")[1];
                if (piecesMap.containsKey(removedPiece)) {
                    piecesMap.remove(removedPiece);
                    System.out.printf("Successfully removed %s!%n", removedPiece);
                }else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", removedPiece);
                }
            }else if (command.contains("ChangeKey")) {
            //3.[0]ChangeKey|[1]{piece}|[2]{new key}":
                String pieceName = command.split("\\|")[1];
                String newTone = command.split("\\|")[2];
                if (piecesMap.containsKey(pieceName)) {
                    piecesMap.get(pieceName).set(1, newTone);
                    System.out.printf("Changed the key of %s to %s!%n", pieceName, newTone);
                }else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                }

            }
            command = scanner.nextLine();
        }
        piecesMap.entrySet().
                forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n", e.getKey(), e.getValue().get(0), e.getValue().get
                        (1)));
    }
}
