package it.unicam.rpg;

import it.unicam.rpg.model.Direction;
import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.data.CardLoader;
import it.unicam.rpg.model.ChoiceEffectApplicator;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*public static void main(String[] args) {
        User user = new User("Edoardo", "player");
        Game game = new Game(user);

        do{
            System.out.println("Destra: " + game.npcs.getFirst().getRight().toString());
            game.choose(Direction.RIGHT, user);
            System.out.println("Parametri utente: " + user.getParameters().toString());
            System.out.println("Sinistra: " + game.npcs.getFirst().getLeft().toString());
            game.choose(Direction.LEFT, user);
            System.out.println("Parametri utente: " + user.getParameters().toString());

        }while(!game.npcs.isEmpty());
        /*for(Npc n : npcs){
            System.out.println("Destra: " + n.getRight().toString());
            applicator.application(user, n, Direction.RIGHT);
            System.out.println("Parametri utente: " + user.getParameters().toString());
            System.out.println("Sinistra: " + n.getLeft().toString());
            applicator.application(user, n, Direction.LEFT);
            System.out.println("Parametri utente: " + user.getParameters().toString());
        }
    }*/
        /*User user = new User("Edoardo", "Bambino di strada");
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
    }*/

}
