package rpg.main;

import rpg.characters.Character;
import rpg.characters.npc.NonPlayerCharacter;
import rpg.characters.pc.PlayerCharacter;
import rpg.characters.pc.Rogue;
import rpg.characters.pc.Warrior;

public class Application {
    public static void main(String[] args) {

        PlayerCharacter pc = setUpPlayer();
        System.out.println(pc.getWeapon().printWeapon());

    }

    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {
        PlayerCharacter newPlayer = new PlayerCharacter();
        System.out.println("Choose your class! \n 1. Warrior \n 2. Rogue");
        int choice = 0;
        while (choice == 0) {
            choice = newPlayer.makeChoice();
            switch (choice) {
                case 1:
                    System.out.println("Warrior!");
                    newPlayer = new Warrior();
                    break;
                case 2:
                    System.out.println("Rogue!");
                    newPlayer = new Rogue();
                    break;
                default:
                    System.out.println("That's not one of the choices! Try again!");
                    choice = 0;
            }
        }
        System.out.println("");
        return newPlayer;
//        throw new UnsupportedOperationException();
    }

    //create some NPC object (with armor & weapons?)
    private static NonPlayerCharacter setUpEnemy() {

        throw new UnsupportedOperationException();
    }

    //a and b battle until one is dead
    private static void battle(Character a, Character b) {
        Character attacker = a;
        Character defender = b;

        while( a.isAlive() && b.isAlive() ){
            if( a.makeChoice()==1) {
                attacker.attack(defender);
            } else {
                //TODO: consider other actions
                throw new UnsupportedOperationException();
            }

            Character temp = a;
            a = b;
            b = temp;

            //TODO: display HP status?
        }
    }

    //display some message
    private static void gameOverScreen() {
        System.out.println("You have died!");
        System.out.println("-------- GAME OVER! --------");
        System.out.println("Would you like to try again?");
    }
}
