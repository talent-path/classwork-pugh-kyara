package rpg.armors;

public class HeavyArmor implements Armor {

    private int dmgReduction;

    public HeavyArmor()
    {
        dmgReduction = 6;
    }

    @Override
    public int reduceDamage(int startingDamage) {
        return startingDamage-dmgReduction;
    }
}
