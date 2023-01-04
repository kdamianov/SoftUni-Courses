package FE04ProgrammingFundamentalsFinalExam;

import java.util.*;
//100/100 в JUDGE!!!

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroesInfoMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            //"{hero name} {HP} {MP}"
            String[] heroesInput = scanner.nextLine().split(" ");
            String hero = heroesInput[0];
            int hp = Integer.parseInt(heroesInput[1]);
            int mp = Integer.parseInt(heroesInput[2]);
            heroesInfoMap.put(hero, new ArrayList<>());
            heroesInfoMap.get(hero).add(hp);
            heroesInfoMap.get(hero).add(mp);
            //[0]{HP} [1]{MP}
        }

        String commandInput = scanner.nextLine();

        while(!commandInput.equals("End")) {
            String[] commandData = commandInput.split(" - ");
            String command = commandData[0];
            String heroName = commandData[1];
            int currentHp = heroesInfoMap.get(heroName).get(0);
            int currentMp = heroesInfoMap.get(heroName).get(1);

            switch (command) {
                case "CastSpell":
                //[0]CastSpell – [1]{hero name} – [2]{MP needed} – [3]{spell name}"
                    int neededMP = Integer.parseInt(commandData[2]);
                    String spellName = commandData[3];
                    if (neededMP <= heroesInfoMap.get(heroName).get(1)) {
                        heroesInfoMap.get(heroName).set(1, currentMp - neededMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spellName, heroesInfoMap.get(heroName).get(1));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                //[0]TakeDamage – [1]{hero name} – [2]{damage} – [3]{attacker}"
                    int damage = Integer.parseInt(commandData[2]);
                    String attacker = commandData[3];
                    int newHp = currentHp - damage;
                    if (newHp > 0) {
                        heroesInfoMap.get(heroName).set(0, newHp);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, newHp);
                    } else {
                        heroesInfoMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                //[0]"Recharge – [1]{hero name} – [2]{amount}"
                    int amountMp = Integer.parseInt(commandData[2]);
                    currentMp += amountMp;
                    if (currentMp > 200) {
                        amountMp = amountMp - (currentMp - 200);
                        currentMp = 200;
                    }
                    heroesInfoMap.get(heroName).set(1, currentMp);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amountMp);
                    break;
                case "Heal":
                //[0]"Heal – [1]{hero name} – [2]{amount}"
                    int amountHp = Integer.parseInt(commandData[2]);
                    currentHp += amountHp;
                    if (currentHp > 100) {
                        amountHp = amountHp - (currentHp - 100);
                        currentHp = 100;

                    }
                    heroesInfoMap.get(heroName).set(0, currentHp);
                    System.out.printf("%s healed for %d HP!%n", heroName, amountHp);
                    break;
            }

            commandInput = scanner.nextLine();
        }
        heroesInfoMap.entrySet().forEach(entry -> System.out.printf("%s%n" +
                "  HP: %d%n" +
                "  MP: %d%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
