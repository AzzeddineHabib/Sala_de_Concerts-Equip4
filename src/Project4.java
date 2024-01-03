package src;
import java.util.Scanner;

public class Project4 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean validOption = true;
        String dni = "";

        System.out.println("Welcome to the concert hall!");

        // Introduction
        System.out.println();
        System.out.println("Who are you?");
        System.out.println("0. Client");
        System.out.println("1. Group of music");
        System.out.println("2. Worker");
        System.out.println("3. Exit");

        int introduction = sc.nextInt();

        if (introduction != 3 && introduction != 2 && introduction != 1 && introduction != 0) {
            validOption = false;
            do {
                System.out.println("\033[31mInvalid option, try again.\033[0m");
                System.out.println();
                System.out.println("Who are you?");
                System.out.println("0. Client");
                System.out.println("1. Group of music");
                System.out.println("2. Worker");
                System.out.println("3. Exit");
                introduction = sc.nextInt();
                if (introduction == 3 || introduction == 2 || introduction == 1 || introduction == 0)
                    validOption = true;
            }
            while (!validOption);
        }

        boolean client = false;
        boolean group = false;
        boolean worker = false;

        switch (introduction) {
            case 0:
                client = true;
                break;
            case 1:
                group = true;
                break;
            case 2:
                worker = true;
                break;
            case 3:
                System.out.println("See you soon!");
                break;
        }

        // Introduce clients data.
        if (client) {
            String[] clientData = new String[3];

            System.out.println("Write your name: ");
            String name = sc.next();
            clientData[0] = name;

            System.out.println("Write your DNI: ");
            dni = sc.next();
            clientData[1] = dni;

            System.out.println("Write your phone number: ");
            String pNumber = sc.next();
            clientData[2] = pNumber;

            System.out.println();
            System.out.println("Which group do you want to see?");
            System.out.println("0. Group1");
            System.out.println("1. Group2");
            System.out.println("2. Group3");
            System.out.println("3. Exit");

            int whichGroup = sc.nextInt();

            if (whichGroup != 3 && whichGroup != 2 && whichGroup != 1 && whichGroup != 0) {

                do {
                    System.out.println("\033[31mInvalid option, try again.\033[0m");
                    System.out.println();
                    System.out.println("Which group do you want to see?");
                    System.out.println("0. Group1");
                    System.out.println("1. Group2");
                    System.out.println("2. Group3");
                    System.out.println("3. Exit");

                    whichGroup = sc.nextInt();
                }
                while (whichGroup != 3 && whichGroup != 2 && whichGroup != 1 && whichGroup != 0);
            }
            int priceTicket = 0;
            int priceStandard = 0;
            int priceVip3 = 0;
            int priceVip2 = 0;
            int priceVip1 = 0;


            switch (whichGroup) {
                case 0:
                    System.out.println();
                    System.out.println("What type of ticket do you want?");
                    System.out.println("0. Standard --> 15€");
                    System.out.println("1. VIP3 --> 25€");
                    System.out.println("2. VIP2 --> 35€");
                    System.out.println("3. VIP1 --> 45€");

                    priceStandard = 15;
                    priceVip3 = 25;
                    priceVip2 = 35;
                    priceVip1 = 45;
                    break;
                case 1:
                    System.out.println();
                    System.out.println("What type of ticket do you want?");
                    System.out.println("0. Standard --> 10€");
                    System.out.println("1. VIP3 --> 20€");
                    System.out.println("2. VIP2 --> 30€");
                    System.out.println("3. VIP1 --> 40€");

                    priceStandard = 10;
                    priceVip3 = 20;
                    priceVip2 = 30;
                    priceVip1 = 40;
                    break;
                case 2:
                    System.out.println();
                    System.out.println("What type of ticket do you want?");
                    System.out.println("0. Standard --> 5€");
                    System.out.println("1. VIP3 --> 15€");
                    System.out.println("2. VIP2 --> 25€");
                    System.out.println("3. VIP1 --> 35€");

                    priceStandard = 5;
                    priceVip3 = 15;
                    priceVip2 = 25;
                    priceVip1 = 35;
                    break;
                case 3:
                    sc.close();
                    System.out.println("See you soon!");
            }

            int ticket = sc.nextInt();

            if (ticket != 3 && ticket != 2 && ticket != 1 && ticket != 0) {
                validOption = false;
                do {
                    System.out.println("\033[31mInvalid option, try again.\033[0m");
                    System.out.println();
                    switch (whichGroup) {
                        case 0:
                            System.out.println();
                            System.out.println("What type of ticket do you want?");
                            System.out.println("0. Standard --> 15€");
                            System.out.println("1. VIP3 --> 25€");
                            System.out.println("2. VIP2 --> 35€");
                            System.out.println("3. VIP1 --> 45€");

                            priceStandard = 15;
                            priceVip3 = 25;
                            priceVip2 = 35;
                            priceVip1 = 45;
                            break;
                        case 1:
                            System.out.println();
                            System.out.println("What type of ticket do you want?");
                            System.out.println("0. Standard --> 10€");
                            System.out.println("1. VIP3 --> 20€");
                            System.out.println("2. VIP2 --> 30€");
                            System.out.println("3. VIP1 --> 40€");

                            priceStandard = 10;
                            priceVip3 = 20;
                            priceVip2 = 30;
                            priceVip1 = 40;
                            break;
                        case 2:
                            System.out.println();
                            System.out.println("What type of ticket do you want?");
                            System.out.println("0. Standard --> 5€");
                            System.out.println("1. VIP3 --> 15€");
                            System.out.println("2. VIP2 --> 25€");
                            System.out.println("3. VIP1 --> 35€");

                            priceStandard = 5;
                            priceVip3 = 15;
                            priceVip2 = 25;
                            priceVip1 = 35;
                            break;
                        case 3:
                            sc.close();
                            System.out.println("See you soon!");
                    }

                    ticket = sc.nextInt();
                    if (ticket == 3 || ticket == 2 || ticket == 1 || ticket == 0) validOption = true;
                }
                while (!validOption);
            }

            switch (ticket) {
                case 0:
                    priceTicket = priceStandard;
                case 1:
                    priceTicket = priceVip3;
                    break;
                case 2:
                    priceTicket = priceVip2;
                    break;
                case 3:
                    priceTicket = priceVip1;
                    break;
            }
            System.out.println();
            System.out.println("The price of the ticket will be " + priceTicket + " €");

            // Drinks
            System.out.println();
            System.out.println("Do you want a drink?");
            System.out.println("0. Yes");
            System.out.println("1. No");

            int drink = sc.nextInt();

            boolean orderAgain = true;
            int totalRecap = 0;
            // LOOP TO KNOW WHAT DRINK AND HOW MANY DRINKS WOULD LIKE THE CLIENT
            if (drink == 0) {
                while (orderAgain) {
                    String[] product = {"Cocktail", "Beer", "Soda", "Water"};
                    int[] drinks = new int[4];
                    int[] drinksPerClient = new int[drinks.length];
                    int codeDrink;
                    for (int i = 0; i < drinksPerClient.length; i++) {
                        do {
                            System.out.println("What do you want to drink?");
                            System.out.println("0. Cocktail");
                            System.out.println("1. Beer");
                            System.out.println("2. Soda");
                            System.out.println("3. Water");
                            codeDrink = sc.nextInt();
                            if (codeDrink < 0 || codeDrink > 3) {
                                System.out.println("\033[31mInvalid option!\033[0m");
                                System.out.println("\033[31mPlease enter a value from the options\033[0m");
                                System.out.println();
                            }
                        } while (codeDrink < 0 || codeDrink > 3);

                        System.out.println();
                        System.out.println("How many drinks do you want?");
                        int numberDrinks = sc.nextInt();
                        switch (codeDrink) {
                            case 0:
                                drinksPerClient[0] += numberDrinks;
                                break;
                            case 1:
                                drinksPerClient[1] += numberDrinks;
                                break;
                            case 2:
                                drinksPerClient[2] += numberDrinks;
                                break;
                            case 3:
                                drinksPerClient[3] += numberDrinks;
                                break;
                        }
                        System.out.println();
                        System.out.println("Do you want anything else to drink?");
                        System.out.println("0. Yes");
                        System.out.println("1. No");
                        int moreDrinks = sc.nextInt();
                        if (moreDrinks == 1) break;
                    }
                    System.out.println("You have chosen:");
                    for (int j = 0; j < drinksPerClient.length; j++) {
                        if (drinksPerClient[j] > 0) {
                            System.out.println(product[j] + ": " + drinksPerClient[j]);
                        }
                    }
                    System.out.println();
                    System.out.println("Is it correct?");
                    System.out.println("0. Yes");
                    System.out.println("1. No, order again");
                    int correctOrder = sc.nextInt();
                    if (correctOrder == 0) {
                        orderAgain = false;
                        //CALCULATE TOTAL PRICE DRINKS
                        int[] prices = {8, 3, 4, 2};
                        int[] totalPrices = new int[drinksPerClient.length];
                        for (int i = 0; i < totalPrices.length; i++) {
                            totalPrices[i] = drinksPerClient[i] * prices[i];
                            totalRecap += totalPrices[i]++;
                        }
                        System.out.println("The price of the drinks will be " + totalRecap + " €.");
                    }
                }
            }
            System.out.println();
            int totalPrice = priceTicket + totalRecap;
            System.out.println("The total price is " + totalPrice + " €.");
        }

        if (group) {
            String[] Group = new String[5];

            System.out.println("Write the name of the group:");
            String nameGroup = sc.nextLine();
            Group[0] = nameGroup;

            System.out.println("How many members are you?");
            String members = sc.nextLine();
            Group[1] = members;

            System.out.println("How long your concerts are?");
            String duration = sc.nextLine();
            Group[2] = duration;

            System.out.println("When do you want to come?");
            String date = sc.nextLine();
            Group[3] = date;

            System.out.println("Write an email to contact with you: ");
            String email = sc.nextLine();
            Group[4] = email;

            System.out.println();
            System.out.println("OK, we will sent you an send you an email. ");
        }

        if (worker) {
            System.out.println();
            System.out.println("What position do you have?");
            System.out.println("0. Manager");
            System.out.println("1. Waiter");
            System.out.println("2. Other Worker");
            System.out.println("3. Exit");

            int position = sc.nextInt();

            boolean Manager = false;
            boolean Waiter = false;
            boolean OtherWorker = false;

            switch (position) {
                case 0:
                    Manager = true;
                    break;
                case 1:
                    Waiter = true;
                    break;
                case 2:
                    OtherWorker = true;
                    break;
                case 3:
                    System.out.println("See you soon!");
                    break;
            }


            if (Manager) {
                System.out.println();
                System.out.println("What do you want to manage?");
                System.out.println("0. Clients");
                System.out.println("1. Groups");
                System.out.println("3. Exit");

                int manage = sc.nextInt();

                boolean Clients = false;
                boolean Groups = false;

                switch (manage) {
                    case 0:
                        Clients = true;
                        break;
                    case 1:
                        Groups = true;
                        break;
                    case 2:
                        System.out.println("See you soon!");
                        break;
                }

                if (Clients) {
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


                if (Groups) {
                    System.out.println("What do you want to know?");
                    System.out.println("0. Make a consult");
                    System.out.println("1. Cancel concert");
                    System.out.println("2. Exit");

                    int clientManage = sc.nextInt();

                    boolean consult = false;
                    boolean delete = false;

                    switch (clientManage) {
                        case 0:
                            consult = true;
                            break;
                        case 1:
                            delete = true;
                            break;
                        case 2:
                            System.out.println("See you soon!");
                            break;
                    }
                    if (consult) {
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

                    if (delete) {
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

                }
            }


            if (Waiter) {
                System.out.println("Coming soon...");
            }

            if (OtherWorker) {
                System.out.println("Welcome, worker!");

                // Introducción para otros trabajadores
                System.out.println("Please provide the following information:");

                System.out.println("Enter your name: ");
                String workerName = sc.nextLine();

                System.out.println("Enter your position: ");
                String workerPosition = sc.nextLine();

                // Recopilar información personal del trabajador
                String workerAddress = getWorkerInfo("Enter your address: ");
                String workerPhoneNumber = getWorkerInfo("Enter your phone number: ");
                String workerStartDate = getWorkerInfo("Enter your start date (DD/MM/YYYY): ");

                // Mostrar la información del trabajador
                System.out.println("Thank you! Here is your information:");
                displayWorkerInfo(workerName, workerPosition, workerAddress, workerPhoneNumber, workerStartDate);
            }

        }

    }
        private static String getWorkerInfo(String prompt) {
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


        private static int displayMenu() {
            System.out.println("What do you want to know?");
            System.out.println("0. Make a consult");
            System.out.println("1. Delete user");
            System.out.println("2. Exit");

            return sc.nextInt();
        }

        private static void makeConsult() {
            System.out.println("Write the DNI: ");
            String dni = sc.next();

            // Database simulation. In the future, you can save data here.
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

            // Database simulation. In the future, you can save data here.
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
}
