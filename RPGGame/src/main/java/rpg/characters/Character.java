package rpg.characters;

import rpg.Chooser;
import rpg.weapons.Weapon;

//TODO:
//      add a concept of hitpoints
//      add a concept of armor (or maybe multiple pieces of armor)
//      add a concept of a weapon (or maybe multiple weapons)
//Stretch goals:
//      add a potion class/interface that the character can drink instead of attacking
//      let the character "disarm" the opponent instead of attacking
//          base this on the weapons used?
//      let the character choose to "block" or "defend"
//          could stun the opponent if they attack?
//          could give us TWO attacks on the next round?
public abstract class Character implements Chooser {

    //TODO: add fields for armor(s) and weapon(s)
    private String name;
    private int hitPoints;
    private int defense;
    private int speed;

    public Character()
    {
        name = " ";
        hitPoints = 20;
        defense = 5;
        speed = 3;
    }

    public Character(String name, int hitPoints, int defense, int speed)
    {
        this.name = name;
        this.hitPoints = hitPoints;
        this.defense = defense;
        this.speed = speed;
    }

    public int getHitPoints()
    {
        return hitPoints;
    }

    public int getDefense()
    {
        return defense;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void attack(Character defender ){


//        throw new UnsupportedOperationException();
    }

    public void takeDamage( int damage ){
        hitPoints = hitPoints - damage;
        if(hitPoints < 0)
        {
            hitPoints = 0;
        }
    }

    public boolean isAlive(){
        return hitPoints > 0;
    }


}
