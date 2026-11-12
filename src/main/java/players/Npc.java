package players;

public abstract class Npc extends Player{
    public Npc(String name, String role){
        super(name, role);
    }
    public abstract Parameters getParameters();
}
