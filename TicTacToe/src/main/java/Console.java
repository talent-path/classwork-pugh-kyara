import java.util.Scanner;

public class Console {

    public static void print(String printmsg) {
        System.out.println(printmsg);
    }

    public static int readInt(String msg, int min, int max) {
        int newInt = readInt(msg);
        while (newInt < min || newInt > max) {
            newInt = readInt(msg);
        }
        return newInt;
    }

    public static int readInt(String msg) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int parsedInt = Integer.MIN_VALUE;
        while (!valid) {
            print(msg);
            String userInput = input.nextLine();
            try {
                parsedInt = Integer.parseInt(userInput);
                valid = true;

            } catch (NumberFormatException ex) {
                //keep looping
            }

        }
        return parsedInt;
    }

    public static double readDouble(String msg, double min, double max) {
        double newDb = readDouble(msg);
        while (newDb < min || newDb > max) {
            newDb = readDouble(msg);
        }
        return newDb;
    }

    public static double readDouble(String msg) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        double parsedDb = Double.MIN_VALUE; //can be Double.NaN to signify not a number
        while (!valid) {
            print(msg);
            String userInput = input.nextLine();
            try {
                parsedDb = Double.parseDouble(userInput);
                valid = true;

            } catch (NumberFormatException ex) {
                //keep looping
            }

        }
        return parsedDb;
    }
    //verifying if an int is passed in
    public static int getInt(Scanner input)
    {
        while(!input.hasNextInt())
        {
            input.nextLine();
            System.out.println("That is not an integer! Try again!");

        }
        return input.nextInt();
    }

}
