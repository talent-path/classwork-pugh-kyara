import java.util.Random;
import java.util.Scanner;

public class Game {
    final static int MIN = 0;
    final static int MAX = 8;
    final static String X = "X";
    final static String O = "O";
    static String yourToken = "";
    static String secondToken = ""; //multiplayer
    static String compToken = "";
    static Random rand = new Random();
    static String [] gameArray;

    //main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Console.print("---Single Player(1)---    ---Multiplayer(2)---    ---Quit(0)--- ");
        int choice = Console.getInt(input);
            switch (choice) {
                case 1:
                    Play();
                    break;
                case 2:
                    Multi();
                    break;
                case 0:
                    Console.print("Come back soon!");
                    break;
                default:
                    Console.print("That's not one of the choices! Choose again!");
                    choice = Console.getInt(input);


        }

    }

    //main playing method
    public static void Play() {
        int quit = 1;
        // do loop allows player to choose whether they want to play again
        do {
        Scanner input = new Scanner(System.in);
        Console.print("How many rounds will you play?");
        int wins = 0;
        int rounds = 1;
        int setRounds = numOfRounds(input);
            //if the player decides to do more than 0 rounds
            if (setRounds > 0) {
                boolean side = coinFlip();
                //keep going for number of rounds given
                while (rounds <= setRounds) {
                    Console.print("RULES: Get three of your token in a row! \nBoard positions start from 0 up to 8. The top leftmost position is 0 and the bottom rightmost position is 8.");
                    Console.print("Round " + rounds);
                    printSide(side);
                    //create a blank board
                    createBlankBoard();
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
                                    Console.print("Match over! " + winner + " is the winner!");
                                    rounds++;
                                    wins++;
                                } else if (compToken.equals(matchUpdate())) {
                                    winner = "Computer";
                                    Console.print("Match over! " + winner + " is the winner!");
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
                                    Console.print("Match over! " + winner + " is the winner!");
                                    rounds++;
                                    wins++;
                                } else if (compToken.equals(matchUpdate())) {
                                    winner = "Computer";
                                    Console.print("Match over! " + winner + " is the winner!");
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
                            Console.print("Match over! Draw!");
                            rounds++;
                        }

                    }

                }
                //output wins
                Console.print("You had " + wins + " win(s).");
            }
            //outout dialog for if the player decides to play no rounds at all
            else {
                Console.print("That's too bad. Goodbye!");
                //leave loop
                break;
            }
            Console.print("Do you want to play again? Yes(1), No(0)");
            quit = Console.getInt(input);
            while(quit != 1 && quit!=0)
            {
                Console.print("Invalid choice try again.");
                quit = Console.getInt(input);
            }
        } while(quit!=0); //end of do loop
        Console.print("Thanks for playing!");
    }

    //determines sides and their token
    public static void printSide(boolean side)
    {
        if (side) {
            Console.print("You are X, you go first.");
            //assign player tokens
            yourToken = X;
            compToken = O;
        } else {
            Console.print("You are O you go second.");
            //assign player tokens
            yourToken = O;
            compToken = X;
        }
    }

    public static void createBlankBoard() {
        gameArray = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
    }

    //print the gameboard
    public static void printGame()
    {
        Console.print(" " + gameArray[0] + " | " + gameArray[1]+ " | "+ gameArray[2]);
        Console.print("---|---|---");
        Console.print(" " + gameArray[3] + " | " + gameArray[4]+ " | "+ gameArray[5]);
        Console.print("---|---|---");
        Console.print(" " + gameArray[6] + " | " + gameArray[7]+ " | "+ gameArray[8]);
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
        Console.print("It's the computer's turn...");
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
        Console.print("Your turn to pick...");
        int userSpot = Console.getInt(input);

        //check is the spot is valid
        if(userSpot < 0 || userSpot > 8)
        {
            //keep asking until a valid spot is given
            while (userSpot < 0 || userSpot > 8)
            {
                Console.print("That spot does not exist! Choose another spot.");
                userSpot = Console.getInt(input);
            }
        }
        //check if the spot chosen is occupied
        if(isOccupied(gameArray, userSpot))
        {
            //keep asking until a valid spot is given
            while (isOccupied(gameArray, userSpot))
            {
                Console.print("That spot is occupied! Choose another spot.");
                userSpot = Console.getInt(input);
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
        Console.print("Flipping to determine player tokens...");
        return rand.nextBoolean();
    }

    //returns how many rounds users would like to play
    public static int numOfRounds(Scanner input)
    {
        int rounds = Console.getInt(input);
        while(rounds < 0)
        {
            Console.print("Cannot play less than zero rounds! Enter again!");
            rounds = Console.getInt(input);
        }
        return rounds;
    }

    //generates numbers 0-8 to represent spots on board
    public static int randInt (int min, int max) {
            int spot = min + rand.nextInt((max - min) + 1);
            return spot;
        }


    //same as Play() but includes a 2nd human player instead of computer
    public static void Multi()
    {
        int quit = 1;
        // do loop allows player to choose whether they want to play again
        do {
            Scanner input = new Scanner(System.in);
            Console.print("How many rounds will you play?");
            int wins1 = 0;
            int wins2 = 0;
            int rounds = 1;
            String player;
            int setRounds = numOfRounds(input);

            //if the player decides to do more than 0 rounds
            if (setRounds > 0) {
                boolean side = coinFlip();
                //keep going for number of rounds given
                while (rounds <= setRounds) {
                    Console.print("Round " + rounds);
                    printSideTwo(side);
                    createBlankBoard();
                    int turns = 1;
                    boolean gameOver = false;
                    String winner = null;
                    while (!gameOver && winner == null) {

                        //player's turn
                        if (side) {
                            player = "Player 1";
                            //asks players to choose a spot and inputs their token
                            updateGame(chooseSpot(input,player), yourToken);
                            printGame();
                            if (gameOver(matchUpdate()) || turns > 9) {
                                gameOver = true;
                                if (yourToken.equals(matchUpdate())) {
                                    winner = "Player 1";
                                    Console.print("Match over! " + winner + " is the winner!");
                                    rounds++;
                                    wins1++;
                                } else if (secondToken.equals(matchUpdate())) {
                                    winner = "Player 2";
                                    Console.print("Match over! " + winner + " is the winner!");
                                    rounds++;
                                    wins2++;
                                }

                            }
                            //switch sides
                            else {
                                side = false;
                                turns++;
                            }
                        }
                        //2nd player's turn
                        else if (!side) {
                            player = "Player 2";
                            updateGame(chooseSpot(input,player), secondToken);
                            printGame();
                            //check if the game is over or if 9 turns have been reached
                            if (gameOver(matchUpdate()) || turns > 9) {
                                gameOver = true;
                                if (yourToken.equals(matchUpdate())) {
                                    winner = "Player 1";
                                    Console.print("Match over! " + winner + " is the winner!");
                                    rounds++;
                                    wins1++;
                                } else if (secondToken.equals(matchUpdate())) {
                                    winner = "Player 2";
                                    Console.print("Match over! " + winner + " is the winner!");
                                    rounds++;
                                    wins2++;
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
                            Console.print("Match over! Draw!");
                            rounds++;
                        }

                    }

                }
                //output wins
                Console.print("Player 1 has " + wins1 + " win(s).");
                Console.print("Player 2 has " + wins2 + " win(s).");
            }
            //outout dialog for if the player decides to play no rounds at all
            else {
                Console.print("That's too bad. Goodbye!");
                //leave loop
                break;
            }
            Console.print("Do you want to play again? Yes(1), No(0)");
            quit = Console.getInt(input);
            while(quit != 1 && quit!=0)
            {
                Console.print("Invalid choice try again.");
                quit = Console.getInt(input);
            }
        } while(quit!=0); //end of do loop
        Console.print("Thanks for playing!");
    }

    //determines sides and their token
    public static void printSideTwo (boolean side)
    {
        if (side) {
            Console.print("Player 1 is X, they go first. Player 2 is O they go second");
            //assign player tokens
            yourToken = X;
            secondToken = O;
        } else {
            Console.print("Player 1 is O, they go second. Player 2 is X they go first");
            //assign player tokens
            yourToken = O;
            secondToken = X;
        }
    }

    //differentiates which player turn it is
    public static int chooseSpot(Scanner input, String player)
    {
        Console.print(player +"'s turn to pick...");
        int userSpot = Console.getInt(input);

        //check is the spot is valid
        if(userSpot < 0 || userSpot > 8)
        {
            //keep asking until a valid spot is given
            while (userSpot < 0 || userSpot > 8)
            {
                Console.print("That spot does not exist! Choose another spot.");
                userSpot = Console.getInt(input);
            }
        }
        //check if the spot chosen is occupied
        if(isOccupied(gameArray, userSpot))
        {
            //keep asking until a valid spot is given
            while (isOccupied(gameArray, userSpot))
            {
                Console.print("That spot is occupied! Choose another spot.");
                userSpot = Console.getInt(input);
            }
        }

        return userSpot;
    }


}
