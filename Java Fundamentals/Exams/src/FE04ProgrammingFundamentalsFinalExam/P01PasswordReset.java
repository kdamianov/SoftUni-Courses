package FE04ProgrammingFundamentalsFinalExam;

import java.util.Scanner;
//100 / 100 Judge

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String commandInput = scanner.nextLine();
        StringBuilder newPassword = new StringBuilder();

        while(!commandInput.equals("Done")) {
            String[] commandLine = commandInput.split(" ");
            String command = commandLine[0];

            switch (command) {
                case "TakeOdd":
                    for (int i = 1; i < password.length(); i += 2) {
                        newPassword.append(password.charAt(i));
                    }
                    password = newPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandLine[1]);
                    int length = Integer.parseInt(commandLine[2]);

                    password = password.substring(0, index) + password.substring(index + length);

                    System.out.println(password);
                    break;
                case "Substitute":
                //[0]"Substitute [1]{substring} [2]{substitute}"
                    String substring = commandLine[1];
                    String substitute = commandLine[2];

                    if (password.contains(substring)) {
                        password = password.replace(substring, substitute);

                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            commandInput = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
