package rpg.weapons;

public class Fist implements Weapon {

    //return 1 dmg as the character currently lost their weapon
    @Override
    public int generateDamage() {

        return 1;
    }

    public String printWeapon()
    {
       return "Fists";
    }
}
