import java.util.Random;
import java.util.Scanner;

public class Game {
    final static int MIN = 0;
    final static int MAX = 8;
    final static String X = "X";
    final static String O = "O";
    static String yourToken = "";
    static String compToken = "";
    static Random rand = new Random();
    static String [] gameArray;

    //main method
    public static void main(String[] args) {

        Play();
    }

    //main playing method
    public static void Play() {
        int quit = 0;
        // do loop allows player to choose whether they want to play again
        do {
        Scanner input = new Scanner(System.in);
        System.out.println("How many rounds will you play?");
        int wins = 0;
        int rounds = 1;
        int setRounds = numOfRounds(input);

            //if the player decides to do more than 0 rounds
            if (setRounds > 0) {
                System.out.println("Flipping to determine your token...");
                boolean side = coinFlip();

                //keep going for number of rounds given
                while (rounds <= setRounds) {
                    System.out.println("Round " + rounds);
                    printSide(side);
                    gameArray = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
                    int turns = 1;
                    boolean gameOver = false;
                    String winner = null;
                    while (!gameOver && winner == null) {

                        //player's turn
                        if (side) {
                            //asks players to choose a spot and inputs their token
                            updateGame(chooseSpot(input), yourToken);
                            printGame();
                            if (gameOver(matchUpdate()) || turns > 9) {
                                gameOver = true;
                                if (yourToken.equals(matchUpdate())) {
                                    winner = "Player";
                                    System.out.println("Match over! " + winner + " is the winner!");
                                    rounds++;
                                    wins++;
                                } else if (compToken.equals(matchUpdate())) {
                                    winner = "Computer";
                                    System.out.println("Match over! " + winner + " is the winner!");
                                    rounds++;
                                }

                            }
                            //switch sides
                            else {
                                side = false;
                                turns++;
                            }
                        }
                        //computer's turn
                        else if (!side) {
                            updateGame(generateSpot(), compToken);
                            printGame();
                            //check if the game is over or if 9 turns have been reached
                            if (gameOver(matchUpdate()) || turns > 9) {
                                gameOver = true;
                                if (yourToken.equals(matchUpdate())) {
                                    winner = "Player";
                                    System.out.println("Match over! " + winner + " is the winner!");
                                    rounds++;
                                    wins++;
                                } else if (compToken.equals(matchUpdate())) {
                                    winner = "Computer";
                                    System.out.println("Match over! " + winner + " is the winner!");
                                    rounds++;
                                }
                            }
                            //switch sides
                            else {
                                side = true;
                                turns++;
                            }
                        }
                        //if no one wins in more than 9 turns declare a draw
                        if (turns > 9 && winner == null) {
                            gameOver = true;
                            System.out.println("Match over! Draw!");
                            rounds++;
                        }

                    }

                }
                //output wins
                System.out.println("You had " + wins + " win(s).");
            }
            //outout dialog for if the player decides to play no rounds at all
            else {
                System.out.println("That's too bad. Goodbye!");
                //leave loop
                break;
            }
            System.out.println("Do you want to play again? Yes(0), No(1)");
            quit = getInt(input);
            while(quit != 1 && quit!=0)
            {
                System.out.println("Invalid choice try again.");
                quit = getInt(input);
            }
        } while(quit!=1); //end of do loop
        System.out.println("Thanks for playing!");
    }

    //determines sides and their token
    public static void printSide(boolean side)
    {
        if (side) {
            System.out.println("You are O, you go first.");
            //assign player tokens
            yourToken = O;
            compToken = X;
        } else {
            System.out.println("You are X you go second.");
            //assign player tokens
            yourToken = X;
            compToken = O;
        }
    }

    //print the gameboard
    public static void printGame()
    {
        System.out.println(" " + gameArray[0] + " | " + gameArray[1]+ " | "+ gameArray[2]);
        System.out.println("---|---|---");
        System.out.println(" " + gameArray[3] + " | " + gameArray[4]+ " | "+ gameArray[5]);
        System.out.println("---|---|---");
        System.out.println(" " + gameArray[6] + " | " + gameArray[7]+ " | "+ gameArray[8]);
    }

    //update array based on the spots given by players
    public static void updateGame(int n, String t)
    {
        gameArray[n] = t;
    }

    //decide win conditions
    public static String matchUpdate()
    {
        String winner = " ";
        for (int i = 0; i < gameArray.length-1; i++) {
            String line = null;
            switch (i) {
                //horizontal win
                case 0:
                    line = gameArray[0] + gameArray[1] + gameArray[2];
                    break;
                case 1:
                    line = gameArray[3] + gameArray[4] + gameArray[5];
                    break;
                case 2:
                    line = gameArray[6] + gameArray[7] + gameArray[8];
                    break;
                //vertical win
                case 3:
                    line = gameArray[0] + gameArray[3] + gameArray[6];
                    break;
                case 4:
                    line = gameArray[1] + gameArray[4] + gameArray[7];
                    break;
                case 5:
                    line = gameArray[2] + gameArray[5] + gameArray[8];
                    break;
                //diagonal win
                case 6:
                    line = gameArray[0] + gameArray[4] + gameArray[8];
                    break;
                case 7:
                    line = gameArray[2] + gameArray[4] + gameArray[6];
                    break;
            }

            //output the winner token
            if (line.equals("XXX")) {
                winner = "X";
            } else if (line.equals("OOO")) {
                winner = "O";
            }
        }
      return winner;
    }

    //output if the game is over because someone has won and their token
    public static boolean gameOver(String m)
    {
        boolean over = false;
        if(m.equals(X))
        {
            return true;
        }
        else if(m.equals(O))
        {
            return true;
        }
        return over;
    }

    //computer generated spot
    //cannot be on an occupied spot
    public static int generateSpot()
    {
        System.out.println("It's the computer's turn...");
        int compSpot = randInt(MIN, MAX);
        while(isOccupied(gameArray, compSpot))
        {
            compSpot = randInt(MIN, MAX);
        }
        return compSpot;
    }


    //user choose the spot they would like
    //cannot be on an occupied spot
    public static int chooseSpot(Scanner input)
    {
        System.out.println("Your turn to pick...");
        int userSpot = getInt(input);

        //check is the spot is valid
        if(userSpot < 0 || userSpot > 8)
        {
            //keep asking until a valid spot is given
            while (userSpot < 0 || userSpot > 8)
            {
                System.out.println("That spot does not exist! Choose another spot.");
                userSpot = getInt(input);
            }
        }
        //check if the spot chosen is occupied
        if(isOccupied(gameArray, userSpot))
        {
            //keep asking until a valid spot is given
            while (isOccupied(gameArray, userSpot))
            {
                System.out.println("That spot is occupied! Choose another spot.");
                userSpot = getInt(input);
            }
        }

        return userSpot;
    }

    //check whether a spot is already filled
    public static boolean isOccupied(String [] a, int spot)
    {

        return (a[spot].equals(X) || a[spot].equals(O));
    }

    //decide whether player will be X or O
    public static boolean coinFlip()
    {

        return rand.nextBoolean();
    }

    //returns how many rounds users would like to play
    public static int numOfRounds(Scanner input)
    {
        int rounds = getInt(input);
        while(rounds < 0)
        {
            System.out.println("Cannot play less than zero rounds! Enter again!");
            rounds = getInt(input);
        }
        return rounds;
    }

    //generates numbers 0-8 to represent spots on board
    public static int randInt (int min, int max) {
            int spot = min + rand.nextInt((max - min) + 1);
            return spot;
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
