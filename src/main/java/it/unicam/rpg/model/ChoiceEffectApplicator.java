package it.unicam.rpg.model;

import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.NpcWithEffect;
import it.unicam.rpg.model.players.Parameters;
import it.unicam.rpg.model.players.User;

//TODO sistemare ChoiceEffectApplicator
public class ChoiceEffectApplicator {
/*
    public boolean application(User user, Npc npc, Direction direction){
        if(npc instanceof NpcWithEffect){
            Parameters userParameters = user.getParameters();
            Parameters npcParameters = ((NpcWithEffect)npc).getParameters();

            int userBrotherhood = userParameters.getBrotherhood();
            int npcBrotherhood = npcParameters.getBrotherhood();
            int userHealth = userParameters.getHealth();
            int npcHealth = npcParameters.getHealth();
            int userEducation = userParameters.getEducation();
            int npcEducation = npcParameters.getEducation();
            int userFear = userParameters.getFear();
            int npcFear = npcParameters.getFear();

            user.getParameters().changeAll(
                    userHealth + npcHealth,
                    userEducation + npcEducation,
                    userFear + npcFear,
                    userBrotherhood + npcBrotherhood);

            return true;
        }

        return false;
    }*/
}
