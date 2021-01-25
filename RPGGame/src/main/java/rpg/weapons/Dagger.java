package rpg.weapons;

public class Dagger implements Weapon{

    //dagger does a base dmg of 5
    @Override
    public int generateDamage() {

        return 5;
    }

    @Override
    public String printWeapon() {
        return "Daggers";
    }
}
