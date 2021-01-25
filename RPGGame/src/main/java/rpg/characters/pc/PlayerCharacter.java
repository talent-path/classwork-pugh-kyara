package rpg.characters.pc;

import java.util.Scanner;

import rpg.Console;
import rpg.characters.Character;
import rpg.weapons.Weapon;

public class PlayerCharacter extends Character {
    Scanner input = new Scanner(System.in);
    private Weapon weapon;

    public PlayerCharacter()
    {
        super();
        weapon = null;
    }

    public PlayerCharacter(String name, int hitPoints, int defense, int speed, Weapon weapon)
    {
        super(name, hitPoints, defense, speed);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    //use scanner here to get something from the user
    @Override
    public int makeChoice() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        System.out.println("What would you like to do?");
        System.out.println("1. Attack \n 2.Defend ");
        while(choice==0)
        {
            choice = Console.getInt(input);
            switch(choice){
                case 1:
                    System.out.println("Attacking!");
                    break;
                case 2:
                    System.out.println("Defending!");
                    break;
                default:
                    System.out.println("Not a valid choice! Try again!");
                    choice = 0;
            }
        }

        return choice;
    }
}
