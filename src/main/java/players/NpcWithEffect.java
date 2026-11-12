package players;

public class NpcWithEffect extends Npc{
    private Parameters parameters;

    public NpcWithEffect(String name, String role) {
        super(name, role);
        parameters = new Parameters();
    }

    public Parameters getParameters() {
        return parameters;
    }

}
