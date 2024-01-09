import java.util.Scanner;
import java.sql.*;

public class ConcertHall {

    static Scanner sc = new Scanner(System.in);
    public static int getIntInput(String prompt, int min, int max) {
        int input;
        boolean validInput;
        do {
            System.out.println(prompt);
            input = sc.nextInt();
            validInput = input >= min && input <= max;
            if (!validInput) {
                System.out.println("\033[31mInvalid option, try again.\033[0m");
            }
        } while (!validInput);
        return input;
    }


    public static String getStringInput(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the concert hall!");

        int introduction = getIntInput("Who are you?\n0. Client\n1. Group of music\n2. Worker\n3. Exit", 0, 3);

        switch (introduction) {
            case 0:
                Clients.processClient();
                break;
            case 1:
                Groups.processGroup();
                break;
            case 2:
                Workers.processWorker();
                break;
            case 3:
                System.out.println("See you soon!");
                break;
        }
    }

    public static void exit(){
        System.out.println("See you soon!");

    }
}


