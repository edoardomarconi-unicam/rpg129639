package it.unicam.rpg.model;

import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.NpcWithEffect;
import it.unicam.rpg.model.players.Parameters;
import it.unicam.rpg.model.players.User;

public class ChoiceEffectApplicator {
    public boolean application(User user, Npc npc, Direction direction) {
        if (npc instanceof NpcWithEffect) {
            if (direction == Direction.LEFT) {
                user.getParameters().changeParameters(npc.getLeft().getEffects());
                return true;
            } else if (direction == Direction.RIGHT) {
                user.getParameters().changeParameters(npc.getRight().getEffects());
                return true;
            }else throw new IllegalArgumentException("Direzione non riconosciuta");
        }else return false;
    }
}
