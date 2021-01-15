import java.util.Scanner;

public class Console {

    public static void print(String printmsg) {
        System.out.println(printmsg);
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
