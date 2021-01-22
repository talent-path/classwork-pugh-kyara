package rpg.armors;

public class LightArmor implements Armor  {

    private int dmgReduction;

    public LightArmor()
    {

        dmgReduction = 3;
    }

    @Override
    public int reduceDamage(int startingDamage) {

        return startingDamage-dmgReduction;
    }
}
