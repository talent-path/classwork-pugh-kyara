package rpg.characters;

import rpg.weapons.Sword;
import rpg.weapons.Weapon;

public class Warrior extends Character{

    private Weapon weapon;

    public Warrior()
    {
        super();
        weapon = null;
    }

    //warrior should only be able to use a sword weapon
    public Warrior(int hitPoints, int defense, int speed, Weapon weapon)
    {
        super(hitPoints, defense, speed);
        this.weapon = weapon;

    }

    @Override
    public String makeChoice() {

        return null;
    }
}
