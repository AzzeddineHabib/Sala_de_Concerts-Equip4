import java.util.Scanner;

public class Groups {
    public static Scanner sc = new Scanner(System.in);
    public static String[] groupData = new String[5];
    public static boolean[][] calendar = new boolean[12][8];
    public static void availableDate(){
        String[] date = groupData[3].split("/");

    }
    public static void processGroup() {
        System.out.println("Write the name of the group:");
        groupData[0] = sc.nextLine();

        System.out.println("How many members are you?");
        groupData[1] = sc.nextLine();

        System.out.println("How long are your concerts?");
        groupData[2] = sc.nextLine();

        System.out.println("When do you want to come? (DD/MM)");
        groupData[3] = sc.nextLine();

        System.out.println("Write an email to contact with you: ");
        groupData[4] = sc.nextLine();

        System.out.println();
        System.out.println("Ok, we will send you an email.");
    }

}
