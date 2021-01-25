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
    public String makeChoice() {
        throw new UnsupportedOperationException();
    }
}
