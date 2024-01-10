package src;
import java.util.Scanner;
import java.sql.*;

public class ConcertHall {

    public static Scanner sc = new Scanner(System.in);
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/concertHallDatabase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "concerthallE4";
    public static Connection con;


    private static void initializeDatabase() {
        try (Connection con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            String createClientsTable = "CREATE TABLE IF NOT EXISTS Clients (" +
                    "client_id SERIAL PRIMARY KEY," +
                    "DNI TEXT UNIQUE," +
                    "first_name TEXT," +
                    "last_name TEXT" +
                    "phone_number INTEGER" +
                    "email TEXT)";
            stmt.execute(createClientsTable);

            String createMusicalGroupsTable = "CREATE TABLE IF NOT EXISTS MusicalGroups (" +
                    "group_id SERIAL PRIMARY KEY," +
                    "group_name TEXT," +
                    "members INTEGER," +
                    "arrival_date DATE" +
                    "duration INTEGER," +
                    "email TEXT)";
            stmt.execute(createMusicalGroupsTable);

            String createOtherWorkerTable = "CREATE TABLE IF NOT EXISTS OtherWorker (" +
                    "worker_id SERIAL PRIMARY KEY," +
                    "worker_name TEXT," +
                    "address TEXT," +
                    "position TEXT," +
                    "phone_number INTEGER," +
                    "start_date DATE)";
            stmt.execute(createOtherWorkerTable);

            String createTicketPricesTable = "CREATE TABLE IF NOT EXISTS TicketsPrices (" +
                    "ticket_price_Nº1 INTEGER," +
                    "ticket_price_Nº2 INTEGER," +
                    "ticket_price_Nº3 INTEGER)";
            stmt.execute(createTicketPricesTable);

            String createDrinksTable = "CREATE TABLE IF NOT EXISTS Drinks (" +
                    "drink_id SERIAL PRIMARY KEY," +
                    "drink_name TEXT," +
                    "price INTEGER," +
                    "FOREIGN KEY(prices) REFERENCES createTicketPricesTable(ticket_price_Nº1, ticket_price_Nº2, ticket_price_Nº3))";
            stmt.execute(createDrinksTable);

            String createConcertsTable = "CREATE TABLE IF NOT EXISTS Concerts (" +
                    "concert_id SERIAL PRIMARY KEY," +
                    "concert_name TEXT," +
                    "concert_date DATE," +
                    "duration INTEGER," +
                    "email TEXT," +
                    "location TEXT)";
            stmt.execute(createConcertsTable);

            // ResultSet rset= stmt.executeQuery("");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void processClient() {
        String[] clientData = new String[6];

        System.out.println("Introduce DNI: ");
        clientData[1] = sc.nextLine();

        System.out.println("Introduce First Name: ");
        clientData[2] = sc.nextLine();

        System.out.println("Introduce Last Name: ");
        clientData[3] = sc.nextLine();

        System.out.println("Introduce Phone Number: ");
        clientData[4] = String.valueOf(sc.nextInt());

        System.out.println("Introduce Email: ");
        clientData[5] = sc.nextLine();

        int whichGroup = getIntInput("Which group do you want to see?\n0. Group1\n1. Group2\n2. Group3\n3. Exit", 0, 3);
        int[] prices = processTicketPrices(whichGroup);

        int ticket = getIntInput("What type of ticket do you want?\n0. Standard\n1. VIP3\n2. VIP2\n3. VIP1", 0, 3);
        int priceTicket = prices[ticket];

        int drink = getIntInput("Do you want a drink?\n0. Yes\n1. No", 0, 1);
        int totalRecap = processDrinks(drink);

        int totalPrice = priceTicket + totalRecap;
        System.out.println("The total price is " + totalPrice + " €.");

        insertClientIntoDatabase(clientData);
    }

    private static void insertClientIntoDatabase(String[] clientData) {
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "INSERT INTO clients (client_id, DNI, first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, clientData[0]);
            preparedStatement.setString(2, clientData[1]);
            preparedStatement.setString(3, clientData[2]);
            preparedStatement.setString(4, clientData[3]);
            preparedStatement.setString(5, clientData[4]);
            preparedStatement.setString(6, clientData[5]);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                System.out.println("See you soon!");
                return new int[0];
        }
        System.out.println("What type of ticket do you want?\n0. Standard --> " + prices[0] +
                "€\n1. VIP3 --> " + prices[1] + "€\n2. VIP2 --> " + prices[2] + "€\n3. VIP1 --> " + prices[3] + "€");
        return prices;
    }

    private static int processDrinks(int drink) {
        int totalRecap = 0;

        if (drink == 0) {
            boolean orderAgain = true;

            while (orderAgain) {
                String[] product = {"Cocktail", "Beer", "Soda", "Water"};

                int[] drinks = new int[4];
                int[] drinksPerClient = new int[drinks.length];
                int codeDrink;

                for (int i = 0; i < drinksPerClient.length; i++) {
                    codeDrink = getIntInput("What do you want to drink?\n0. Cocktail\n1. Beer\n2. Soda\n3. Water", 0, 3);

                    System.out.println("How many drinks do you want?");
                    int numberDrinks = sc.nextInt();

                    drinksPerClient[codeDrink] += numberDrinks;

                    System.out.println("Do you want anything else to drink?\n0. Yes\n1. No");
                    int moreDrinks = sc.nextInt();
                    if (moreDrinks == 1) {
                        break;
                    }
                }

                displaySelectedDrinks(product, drinksPerClient);
                int correctOrder = getIntInput("Is it correct?\n0. Yes\n1. No, order again", 0, 1);
                if (correctOrder == 0) {
                    orderAgain = false;
                    totalRecap = calculateTotalPriceDrinks(drinksPerClient);
                    System.out.println("The price of the drinks will be " + totalRecap + " €.");
                }
            }
        }
        return totalRecap;
    }

    private static void displaySelectedDrinks(String[] product, int[] drinksPerClient) {
        System.out.println("You have chosen:");
        for (int j = 0; j < drinksPerClient.length; j++) {
            if (drinksPerClient[j] > 0) {
                System.out.println(product[j] + ": " + drinksPerClient[j]);
            }
        }
    }

    private static int calculateTotalPriceDrinks(int[] drinksPerClient) {
        int[] prices = {8, 3, 4, 2};
        int totalRecap = 0;
        for (int i = 0; i < drinksPerClient.length; i++) {
            totalRecap += drinksPerClient[i] * prices[i];
        }
        return totalRecap;
    }

    private static void processGroup() {
        String[] groupData = new String[6];

        System.out.println("Introduce the Name of the group: ");
        groupData[1] = sc.nextLine();

        System.out.println("Introduce how Many Members are: ");
        groupData[2] = sc.nextLine();

        System.out.println("Introduce when you will come to the Concert: ");
        groupData[3] = sc.nextLine();

        System.out.println("Introduce How long are the Concerts: ");
        groupData[4] = sc.nextLine();

        System.out.println("Introduce a contact email: ");
        groupData[5] = sc.nextLine();

        System.out.println("\n OK, we will send you an email of the status.");

        insertGroupIntoDatabase(groupData);
    }

    private static void insertGroupIntoDatabase(String[] groupData) {
        try (PreparedStatement prepstmt = con.prepareStatement(
                "INSERT INTO groups (group_id, group_name, members, arrival_date, duration, email) VALUES (?, ?, ?, ?, ?, ?)")) {
            prepstmt.setString(1, groupData[0]);
            prepstmt.setString(2, groupData[1]);
            prepstmt.setString(3, groupData[2]);
            prepstmt.setString(4, groupData[3]);
            prepstmt.setString(5, groupData[4]);
            prepstmt.setString(6, groupData[5]);
            prepstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        String[] workerData = new String[7];

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

        insertWorkerIntoDatabase(workerData);
    }

    private static void insertWorkerIntoDatabase(String[] workerData) {
        try (PreparedStatement prepstmt = con.prepareStatement(
                "INSERT INTO workers (worker_id, worker_name, address, position, phone_number, start_date) VALUES (?, ?, ?, ?, ?, ?)")) {
            prepstmt.setString(1, workerData[0]);
            prepstmt.setString(2, workerData[1]);
            prepstmt.setString(3, workerData[2]);
            prepstmt.setString(4, workerData[3]);
            prepstmt.setString(5, workerData[4]);
            prepstmt.setString(6, workerData[5]);
            prepstmt.setString(7, workerData[6]);
            prepstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getStringInput(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    private static void displayWorkerInfo(String name, String position, String address, String phoneNumber, String startDate) {
        System.out.println("Worker ID: ");
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
        initializeDatabase();
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