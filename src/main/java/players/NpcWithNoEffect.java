package players;

public class NpcWithNoEffect extends Npc{
    public NpcWithNoEffect(String name, String role, int health, int education, int fear, int brotherhood){
        super(name, role);
    }

    /*TODO implementare nuova eccezione che riconosca quando
            quando npc non ha nessun effetto sui parametri dello user
     */
    public Parameters getParameters() {
        return null;
    }
}
