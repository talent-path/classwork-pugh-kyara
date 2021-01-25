package rpg.weapons;

public class Sword implements Weapon{

    //sword does a base of 4 dmg
    @Override
    public int generateDamage() {

        return 3;
    }

    @Override
    public String printWeapon() {
        return "Sword";
    }
}
