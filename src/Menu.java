package src;

import org.w3c.dom.css.CSSImportRule;

import java.util.*;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.println("Is your first time here?");
//        System.out.println("0. Yes");
//        System.out.println("1. No");
//
//        int firstTime = sc.nextInt();
//
//        if (firstTime == 0) {
//        }


        // Introduction
        System.out.println("Who are you?");
        System.out.println("0. Client");
        System.out.println("1. Group of music");
        System.out.println("2. Worker");

        int introduction = sc.nextInt();

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
        }

        if (client) {

            System.out.println("Which group do you want to see?");
            System.out.println("0. Group1");
            System.out.println("1. Group2");
            System.out.println("2. Group3");

            int whichGroup = sc.nextInt();

            // What group
            boolean Group1 = false;
            boolean Group2 = false;
            boolean Group3 = false;

            System.out.println("What type of ticket do you want?");
            System.out.println("0. Standard");
            System.out.println("1. VIP3");
            System.out.println("2. VIP2");
            System.out.println("3. VIP1");

            int ticket = sc.nextInt();

            // Type of ticket
            boolean standard = false;
            boolean VIP3 = false;
            boolean VIP2 = false;
            boolean VIP1 = false;


            switch (whichGroup) {
                case 0:
                    Group1 = true;
                    switch (ticket) {
                        case 0:
                            standard = true;
                            break;
                        case 1:
                            VIP3 = true;
                            break;
                        case 2:
                            VIP2 = true;
                            break;
                        case 3:
                            VIP1 = true;
                            break;
                    }
                    break;
                case 1:
                    Group2 = true;
                    switch (ticket) {
                        case 0:
                            standard = true;
                            break;
                        case 1:
                            VIP3 = true;
                            break;
                        case 2:
                            VIP2 = true;
                            break;
                        case 3:
                            VIP1 = true;
                            break;
                    }
                    break;
                case 2:
                    Group3 = true;
                    switch (ticket) {
                        case 0:
                            standard = true;
                            break;
                        case 1:
                            VIP3 = true;
                            break;
                        case 2:
                            VIP2 = true;
                            break;
                        case 3:
                            VIP1 = true;
                            break;
                    }
                    break;
            }



            System.out.println("Do you want a drink?");
            System.out.println("0. Yes");
            System.out.println("1. No");

            int  drink = sc.nextInt();

            boolean orderAgain = true;
            // LOOP TO KNOW WHAT DRINK AND HOW MANY DRINKS WOULD LIKE THE CLIENT
            if (drink == 0) {
                while (orderAgain) {
                    String[] product = {"Cocktail", "Beer", "Soda", "Water"};
                    int[] drinks = new int[4];
                    int[] drinksPerClient = new int[drinks.length];
                    int codeDrink;
                    for (int i = 0; i < drinksPerClient.length; i++) {
                        System.out.println("What do you want to drink?");
                        System.out.println("0. Cocktail");
                        System.out.println("1. Beer");
                        System.out.println("2. Soda");
                        System.out.println("3. Water");
                        codeDrink = sc.nextInt();

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
                    System.out.println("Is it correct?");
                    System.out.println("0. Yes");
                    System.out.println("1. No, order again");
                    int correctOrder = sc.nextInt();
                    if (correctOrder == 0) {
                        orderAgain = false;
                        //CALCULATE TOTAL PRICE DRINKS
                        int[] prices = {8, 3, 4, 2};
                        int[] totalPrices = new int[drinksPerClient.length];
                        int totalRecap = 0;
                        for (int i = 0; i < totalPrices.length; i++) {
                            totalPrices[i] = drinksPerClient[i] * prices[i];
                            totalRecap += totalPrices[i]++;
                        }
                        System.out.println("The total price for the drinks will be " + totalRecap + " €.");
                    }
                }
            }


        }

        if (group) {
            // coming soon
        }

        if (worker) {
            // coming soon
        }
    }
}
