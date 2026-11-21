package it.unicam.rpg.model;

import java.util.Map;
import java.util.Objects;

public class Choice {

    private String label;
    private final Map<ParameterType, Integer> effects;

    // choice di una card con effetti
    public Choice(String label, Map<ParameterType, Integer> effects) {
        this.label = label;
        this.effects = (effects == null) ? Map.of() : Map.copyOf(effects);
    }

    // choice di una card senza effetti
    public Choice(String label) {
        this(label, Map.of());
    }

    public String getLabel() {
        return label;
    }

    public Map<ParameterType, Integer> getEffects() {
        return effects;
    }

    public boolean hasEffects() {
        return !effects.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Choice choice)) return false;
        return Objects.equals(label, choice.label)
                && Objects.equals(effects, choice.effects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, effects);
    }

    @Override
    public String toString() {
        return "Choice{label='" + label + "', effects=" + effects + "}";
    }
}