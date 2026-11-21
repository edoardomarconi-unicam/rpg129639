package it.unicam.rpg.model;

import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.NpcWithEffect;
import it.unicam.rpg.model.players.User;

import java.util.Map;

public class ChoiceEffectApplicator {
    private Difficulty difficulty;
    public ChoiceEffectApplicator(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    public boolean application(User user, Npc npc, Direction direction) {
        if (npc instanceof NpcWithEffect) {
            Map<ParameterType, Integer> leftEffects = npc.getLeft().getEffects();
            Map<ParameterType, Integer> rightEffects = npc.getRight().getEffects();

            leftEffects.forEach((parameterType, value) -> {
                value = difficulty.apply(value);
            });

            rightEffects.forEach((parameterType, value) -> {
                value = difficulty.apply(value);
            });

            if (direction == Direction.LEFT) {
                user.getParameters().changeParameters(leftEffects);
                return true;
            } else if (direction == Direction.RIGHT) {
                user.getParameters().changeParameters(rightEffects);
                return true;
            }else throw new IllegalArgumentException("Direzione non riconosciuta");
        }else return false;
    }
}
