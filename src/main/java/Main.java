import players.Npc;
import players.NpcWithEffect;
import players.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("Edoardo", "Bambino di strada");
        Npc npcEffect = new NpcWithEffect("Gol", "Orco");
        npcEffect.getParameters().changeAll(12, -3, 0, -11);

        System.out.println(npcEffect.getName() + " " + npcEffect.getRole() +  " " + npcEffect.getParameters().getHealth() + " " + npcEffect.getParameters().getEducation() + " " + npcEffect.getParameters().getFear() + " " + npcEffect.getParameters().getBrotherhood() + " " );
        System.out.println(user.getName() + " " + user.getRole() +  " " + user.getParameters().getHealth() + " " + user.getParameters().getEducation() + " " + user.getParameters().getFear() + " " + user.getParameters().getBrotherhood() + " " );

        ChoiceEffectApplicator applicator = new ChoiceEffectApplicator();
        applicator.application(user, npcEffect);
        System.out.println(user.getName() + " " + user.getRole() +  " " + user.getParameters().getHealth() + " " + user.getParameters().getEducation() + " " + user.getParameters().getFear() + " " + user.getParameters().getBrotherhood() + " " );



    }
}
