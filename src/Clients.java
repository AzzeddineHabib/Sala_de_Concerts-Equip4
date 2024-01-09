import java.util.Scanner;

public class Clients {
    public static Scanner sc = new Scanner(System.in);
    public static void processClient() {
        String[] clientData = new String[3];

        System.out.println("Write your name: ");
        clientData[0] = sc.next();

        System.out.println("Write your DNI: ");
        clientData[1] = sc.next();

        System.out.println("Write your phone number: ");
        clientData[2] = sc.next();

        int whichGroup = ConcertHall.getIntInput("Which group do you want to see?\n0. Group1\n1. Group2\n2. Group3\n3. Exit", 0, 3);
        int[] prices = processTicketPrices(whichGroup);

        int ticket = ConcertHall.getIntInput("What type of ticket do you want?\n0. Standard\n1. VIP3\n2. VIP2\n3. VIP1", 0, 3);
        int priceTicket = prices[ticket];

        Drinks.drinkRequest();
        totalPrice();
    }
    public static int[] processTicketPrices(int whichGroup) {
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

    public static void totalPrice() {
        //priceTicket + Falta linkear con clase tickets para el total
        int totalPrice = Drinks.totalRecap;
        System.out.println("\nThe total price is " + totalPrice + " €.");
    }
}
