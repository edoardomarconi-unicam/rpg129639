package it.unicam.rpg;

import it.unicam.rpg.model.data.CardLoader;
import it.unicam.rpg.model.ChoiceEffectApplicator;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("Edoardo", "Bambino di strada");
        List<Npc> npc = CardLoader.LoadNpcs();

        for(Npc n : npc){
            System.out.println(n.getClass().getSimpleName().toString() + " " + n.getName() + " " + n.getRole());
        }
        System.out.println(user.getName() + " " + user.getRole() +  " " + user.getParameters().getHealth() + " " + user.getParameters().getEducation() + " " + user.getParameters().getFear() + " " + user.getParameters().getBrotherhood() + " " );

        ChoiceEffectApplicator applicator = new ChoiceEffectApplicator();
        for(Npc n : npc){
            applicator.application(user, n);
            System.out.println(user.getName() + " " + user.getRole() +  " " + user.getParameters().getHealth() + " " + user.getParameters().getEducation() + " " + user.getParameters().getFear() + " " + user.getParameters().getBrotherhood() + " " );
        }
    }
}
