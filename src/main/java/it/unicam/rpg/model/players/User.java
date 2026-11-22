package it.unicam.rpg.model.players;

import it.unicam.rpg.model.card.ParameterType;

public class User extends Player {
    private Parameters parameters;

    public User(String name, String role) {
        super(name, role);
        this.parameters = new Parameters();
    }

    //getter dei parametri
    public Parameters getParameters() {return parameters;}

    public double getHealth(){
        return (double) parameters.getValues().get(ParameterType.HEALTH);
    }
    public double getEducation(){
        return (double) parameters.getValues().get(ParameterType.EDUCATION);
    }
    public double getBrotherhood(){
        return (double) parameters.getValues().get(ParameterType.BROTHERHOOD);
    }
    public double getFear(){
        return (double) parameters.getValues().get(ParameterType.FEAR);
    }
    public void setParameters(Parameters parameters){this.parameters = parameters;}
}