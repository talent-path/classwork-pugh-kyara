package rpg.characters.pc;

import rpg.characters.pc.PlayerCharacter;
import rpg.weapons.Sword;
import rpg.weapons.Weapon;

public class Warrior extends PlayerCharacter {

    private Weapon weapon;

    //warrior should only be able to use a sword weapon
    public Warrior()
    {
        super();
        setSpeed(3);
        setWeapon(new Sword());
    }

    public Warrior(String name, int hitPoints, int defense, Weapon weapon)
    {
        super(name, hitPoints, defense, 3, weapon);

    }

    @Override
    public String makeChoice() {

        return null;
    }
}
