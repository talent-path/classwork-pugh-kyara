package rpg.characters;

import rpg.weapons.Dagger;
import rpg.weapons.Weapon;

public class Rogue extends Character {

    private Weapon weapon;

    public Rogue()
    {
        super();
        this.speed = 5;
    }

    //rogue should only be able to use a dagger weapon
    public Rogue(String name, int hitPoints, int defense, int speed, Weapon weapon)
    {
        super(name,hitPoints, defense, 5);
        this.weapon = weapon;
    }


    @Override
    public String makeChoice() {
        return null;
    }
}
