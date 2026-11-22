package it.unicam.rpg.model.card;

import it.unicam.rpg.model.settings.Difficulty;
import it.unicam.rpg.model.Direction;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.NpcWithEffect;
import it.unicam.rpg.model.players.User;

import java.util.EnumMap;
import java.util.Map;

public class ChoiceEffectApplicator {
    private Difficulty difficulty;
    public ChoiceEffectApplicator(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    public boolean application(User user, Npc npc, Direction direction) {
        if (npc instanceof NpcWithEffect) {
            if (direction == Direction.LEFT) {
                user.getParameters().changeParameters(
                        scaled(npc.getLeft().getEffects()));
                return true;
            } else if (direction == Direction.RIGHT) {
                user.getParameters().changeParameters(
                        scaled(npc.getRight().getEffects()));
                return true;
            }else throw new IllegalArgumentException("Direzione non riconosciuta");
        }else return false;
    }

    private Map<ParameterType, Integer> scaled(Map<ParameterType, Integer> effects) {
        Map<ParameterType, Integer> result = new EnumMap<>(ParameterType.class);
        effects.forEach((type, value) -> result.put(type, difficulty.apply(value)));
        return result;
    }

    public void difficultyChanged(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
