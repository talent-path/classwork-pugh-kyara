package rpg.characters.npc;

//goblins always attack?
public class Goblin extends NonPlayerCharacter {
    @Override
    public String makeChoice() {

        return "Attack";
    }
}
