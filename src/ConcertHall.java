package src;
import java.util.Scanner;

public class ConcertHall {

    static Scanner sc = new Scanner(System.in);

    private static void processClient() {
        String[] clientData = new String[3];

        System.out.println("Write your name: ");
        clientData[0] = sc.next();

        System.out.println("Write your DNI: ");
        clientData[1] = sc.next();

        System.out.println("Write your phone number: ");
        clientData[2] = sc.next();

        int whichGroup = getIntInput("Which group do you want to see?\n0. Group1\n1. Group2\n2. Group3\n3. Exit", 0, 3);
        int[] prices = processTicketPrices(whichGroup);

        int ticket = getIntInput("What type of ticket do you want?\n0. Standard\n1. VIP3\n2. VIP2\n3. VIP1", 0, 3);
        int priceTicket = prices[ticket];

        int drink = getIntInput("Do you want a drink?\n0. Yes\n1. No", 0, 1);
        int totalRecap = processDrinks(drink);

        int totalPrice = priceTicket + totalRecap;
        System.out.println("The total price is " + totalPrice + " €.");
    }

    private static int getIntInput(String prompt, int min, int max) {
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

    private static int[] processTicketPrices(int whichGroup) {
        int[] prices;
        switch (whichGroup) {
            case 0:
                prices = new int[]{15, 25, 35, 45};
                break;
            case 1:
                prices = new int[]{10, 20, 30, 40};
                break;
            case 2:
                prices = new int[]{5, 15, 25, 35};
                break;
            default:
                sc.close();
                System.out.println("See you soon!");
                return new int[0];
        }
        System.out.println("What type of ticket do you want?\n0. Standard --> " + prices[0] +
                "€\n1. VIP3 --> " + prices[1] + "€\n2. VIP2 --> " + prices[2] + "€\n3. VIP1 --> " + prices[3] + "€");
        return prices;
    }
//DRINK REQUEST
    static {
        Drinks.DrinkRequest();
    }

    private static void processGroup() {
        String[] groupData = new String[5];

        System.out.println("Write the name of the group:");
        groupData[0] = sc.nextLine();

        System.out.println("How many members are you?");
        groupData[1] = sc.nextLine();

        System.out.println("How long are your concerts?");
        groupData[2] = sc.nextLine();

        System.out.println("When do you want to come?");
        groupData[3] = sc.nextLine();

        System.out.println("Write an email to contact with you: ");
        groupData[4] = sc.nextLine();

        System.out.println();
        System.out.println("OK, we will send you an email.");
    }

    private static void processWorker() {
        System.out.println("What position do you have?");
        System.out.println("0. Manager\n1. Waiter\n2. Other Worker\n3. Exit");

        int position = getIntInput("", 0, 3);

        switch (position) {
            case 0:
                processManager();
                break;
            case 1:
                processWaiter();
                break;
            case 2:
                processOtherWorker();
                break;
            case 3:
                System.out.println("See you soon!");
                break;
        }
    }

    private static void processManager() {
        System.out.println("What do you want to manage?");
        System.out.println("0. Clients\n1. Groups\n2. Exit");

        int manage = getIntInput("", 0, 2);

        switch (manage) {
            case 0:
                processClients();
                break;
            case 1:
                processGroups();
                break;
            case 2:
                System.out.println("See you soon!");
                break;
        }
    }

    private static void processClients() {
        int clientManage = displayMenu();

        switch (clientManage) {
            case 0:
                makeConsult();
                break;
            case 1:
                deleteUser();
                break;
            case 2:
                System.out.println("See you soon!");
                break;
        }
    }

    private static void processGroups() {
        System.out.println("What do you want to know?");
        System.out.println("0. Make a consult\n1. Cancel concert\n2. Exit");

        int groupManage = getIntInput("", 0, 2);

        switch (groupManage) {
            case 0:
                consultGroup();
                break;
            case 1:
                cancelConcert();
                break;
            case 2:
                System.out.println("See you soon!");
                break;
        }
    }

    private static void consultGroup() {
        System.out.println("Write the name of the group: ");
        String nameGroup = sc.nextLine();

        String[][] concerts = {
                {"Concert 1", "m1", "Day 1", "Duration 1", "Email 1"},
                {"Concert 2", "m2", "Day 2", "Duration 2", "Email 2"},
                {"Concert 3", "m3", "Day 3", "Duration 3", "Email 3"}};

        boolean found = false;

        for (int i = 0; i < concerts.length; i++) {
            if (concerts[i][1] != null && concerts[i][1].equals(nameGroup)) {
                found = true;
                System.out.println("Name: " + concerts[i][0]);
                System.out.println("Date: " + concerts[i][1]);
                System.out.println("Duration: " + concerts[i][2]);
                break;
            }
        }

        if (!found) {
            System.out.println("That group is not registered.");
        }
    }

    private static void cancelConcert() {
        System.out.println("Write the name of the group: ");
        String nameGroup = sc.nextLine();

        String[][] concerts = {
                {"Concert 1", "m1", "Day 1", "Duration 1", "Email 1"},
                {"Concert 2", "m2", "Day 2", "Duration 2", "Email 2"},
                {"Concert 3", "m3", "Day 3", "Duration 3", "Email 3"}};

        boolean deleted = false;

        for (int i = 0; i < concerts.length; i++) {
            if (concerts[i][1].equals(nameGroup)) {
                deleted = true;
                concerts[i] = null;
                System.out.println("The concert of " + nameGroup + " has been cancelled");
                break;
            }
        }

        if (!deleted) {
            System.out.println("That group is not registered.");
        }
    }

    private static void processWaiter() {
        System.out.println("Coming soon...");
    }

    private static void processOtherWorker() {
        System.out.println("Welcome, worker!");

        // Introduction for other workers
        System.out.println("Please provide the following information:");

        String workerName = getStringInput("Enter your name: ");
        String workerPosition = getStringInput("Enter your position: ");

        String workerAddress = getWorkerInfo("Enter your address: ");
        String workerPhoneNumber = getWorkerInfo("Enter your phone number: ");
        String workerStartDate = getWorkerInfo("Enter your start date (DD/MM/YYYY): ");

        System.out.println("Thank you! Here is your information:");
        displayWorkerInfo(workerName, workerPosition, workerAddress, workerPhoneNumber, workerStartDate);
    }

    private static String getStringInput(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    private static void displayWorkerInfo(String name, String position, String address, String phoneNumber, String startDate) {
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Start Date: " + startDate);
    }

    private static String getWorkerInfo(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    private static int displayMenu() {
        System.out.println("What do you want to know?");
        System.out.println("0. Make a consult\n1. Delete user\n2. Exit");
        return getIntInput("", 0, 2);
    }

    private static void makeConsult() {
        System.out.println("Write the DNI: ");
        String dni = sc.next();

        String[][] clients = {
                {"Name1", "DNI2", "Phone1"},
                {"Name2", "DNI2", "Phone2"},
                {"Name3", "DNI3", "Phone3"}};

        boolean found = false;

        for (int i = 0; i < clients.length; i++) {
            if (clients[i][1].equals(dni)) {
                found = true;
                displayClientInfo(clients[i]);
                break;
            }
        }

        if (!found) {
            System.out.println("That DNI is not registered.");
        }
    }

    private static void deleteUser() {
        System.out.println("Write the DNI from the user you want to delete: ");
        String dni = sc.next();

        String[][] clients = {
                {"Name1", "DNI2", "Phone1"},
                {"Name2", "DNI2", "Phone2"},
                {"Name3", "DNI3", "Phone3"}};

        boolean deleted = false;

        for (int i = 0; i < clients.length; i++) {
            if (clients[i][1].equals(dni)) {
                deleted = true;
                clients[i] = null;
                System.out.println("The client with DNI " + dni + " has been deleted");
                break;
            }
        }

        if (!deleted) {
            System.out.println("That DNI is not registered.");
        }
    }

    static void displayClientInfo(String[] client) {
        System.out.println("Name: " + client[0]);
        System.out.println("DNI: " + client[1]);
        System.out.println("Phone number: " + client[2]);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the concert hall!");

        int introduction = getIntInput("Who are you?\n0. Client\n1. Group of music\n2. Worker\n3. Exit", 0, 3);

        switch (introduction) {
            case 0:
                processClient();
                break;
            case 1:
                processGroup();
                break;
            case 2:
                processWorker();
                break;
            case 3:
                System.out.println("See you soon!");
                break;
        }
    }
}


