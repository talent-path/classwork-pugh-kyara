package rpg.characters;

//goblins always attack?
public class Goblin extends NonPlayerCharacter {
    @Override
    public String makeChoice() {

        return "Attack";
    }
}
