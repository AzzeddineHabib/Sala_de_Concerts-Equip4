package src;

import java.util.Scanner;

public class Drinks {
    public static Scanner sc = new Scanner(System.in);

    public static int DoYouWantaDrink(){
        System.out.println("\nDo you want a drink?");
        System.out.println("0. Yes");
        System.out.println("1. No");
        return sc.nextInt();
    }

    //Type of Drinks
    public static String[] typeOfDrink = {"Cocktail", "Beer", "Soda", "Water"};
    //Price of the Drinks
    public static int[] prices = {8, 3, 4, 2};

    public static int[] drinks = new int[4];
    public static int[] drinksPerClient = new int[drinks.length];
    public static int[] totalPrices = new int[drinksPerClient.length];
    public static int codeDrink;

    public static void DrinksMenu() {
        for (int i = 0; i < drinksPerClient.length; i++) {
            do {
                System.out.println("\n What do you want to drink?");
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
            chooseDrinks();
            if (addDrinks() == 1) break;
        }
    }

    public static void chooseDrinks(){
        System.out.println("\nHow many drinks do you want?");
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
    }

    public static int addDrinks(){
        System.out.println("\nDo you want anything else to drink?");
        System.out.println("0. Yes");
        System.out.println("1. No");
        return sc.nextInt();
    }

    public static void showDrinks(){
        System.out.println("You have chosen:");
        for (int j = 0; j < drinksPerClient.length; j++) {
            if (drinksPerClient[j] > 0) {
                System.out.println(typeOfDrink[j] + ": " + drinksPerClient[j]);
            }
        }
    }

    public static int confirmRequest(){
        System.out.println("\nIs it correct?");
        System.out.println("0. Yes");
        System.out.println("1. No, order again");
        return sc.nextInt();
    }
    public static int totalRecap = 0;

    public static void priceOfDrinks(){
        for (int i = 0; i < totalPrices.length; i++) {
            totalPrices[i] = drinksPerClient[i] * prices[i];
            totalRecap += totalPrices[i]++;
        }
        System.out.println("The price of the drinks will be " + totalRecap + " €.");
    }

    public static void totalPrice() {
        //priceTicket + Falta linkear con clase tickets para el total
        int totalPrice =  totalRecap;
        System.out.println("\nThe total price is " + totalPrice + " €.");
    }

}



