package banking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        UserInterface userInterface = new UserInterface();

        do {
            exitProgram = userInterface.mainMenu(scanner);
        } while (!exitProgram);

    }
}
