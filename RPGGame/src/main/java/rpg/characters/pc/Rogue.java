package rpg.characters.pc;
import rpg.characters.pc.PlayerCharacter;
import rpg.weapons.Dagger;
import rpg.weapons.Weapon;

public class Rogue extends PlayerCharacter {

    //rogue should only be able to use a dagger weapon
    public Rogue()
    {
        super();
        setSpeed(5);
        setWeapon(new Dagger());
    }


    public Rogue(String name, int hitPoints, int defense, Weapon weapon)
    {
        super(name,hitPoints, defense,5, weapon);
    }


    @Override
    public int makeChoice() {

        return super.makeChoice();
    }
}
