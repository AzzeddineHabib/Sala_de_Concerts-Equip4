import java.util.Scanner;

public class Workers {

    public static Scanner sc = new Scanner(System.in);

    public static void processWorker() {
        System.out.println("What position do you have?");
        System.out.println("0. Manager\n1. Waiter\n2. Other Worker\n3. Exit");

        int position = ConcertHall.getIntInput("", 0, 3);

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

    public static void processManager() {
        System.out.println("What do you want to manage?");
        System.out.println("0. Clients\n1. Groups\n2. Exit");

        int manage = ConcertHall.getIntInput("", 0, 2);

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

    public static void processClients() {
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

    public static void processGroups() {
        System.out.println("What do you want to know?");
        System.out.println("0. Make a consult\n1. Cancel concert\n2. Exit");

        int groupManage = ConcertHall.getIntInput("", 0, 2);

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

    public static void consultGroup() {
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

    public static void cancelConcert() {
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

    public static void processWaiter() {
        System.out.println("Coming soon...");
    }

    public static void processOtherWorker() {
        System.out.println("Welcome, worker!");

        // Introduction for other workers
        System.out.println("Please provide the following information:");

        String workerName = ConcertHall.getStringInput("Enter your name: ");
        String workerPosition = ConcertHall.getStringInput("Enter your position: ");

        String workerAddress = getWorkerInfo("Enter your address: ");
        String workerPhoneNumber = getWorkerInfo("Enter your phone number: ");
        String workerStartDate = getWorkerInfo("Enter your start date (DD/MM/YYYY): ");

        System.out.println("Thank you! Here is your information:");
        displayWorkerInfo(workerName, workerPosition, workerAddress, workerPhoneNumber, workerStartDate);
    }

    public static String getWorkerInfo(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public static int displayMenu() {
        System.out.println("What do you want to know?");
        System.out.println("0. Make a consult\n1. Delete user\n2. Exit");
        return ConcertHall.getIntInput("", 0, 2);
    }

    public static void makeConsult() {
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

    public static void deleteUser() {
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

    public static void displayWorkerInfo(String name, String position, String address, String phoneNumber, String startDate) {
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Start Date: " + startDate);
    }
}
