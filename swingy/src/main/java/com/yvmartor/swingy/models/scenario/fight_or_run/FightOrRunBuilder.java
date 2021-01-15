package com.yvmartor.swingy.models.scenario.fight_or_run;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.adventure.Adventure;
import com.yvmartor.swingy.models.scenario.adventure.AdventureBuilder;
import com.yvmartor.swingy.models.scenario.question.Question;
import com.yvmartor.swingy.models.vilains.Vilain;

public class FightOrRunBuilder {
    Hero hero;
    Vilain vilain;
    Question question;

    public FightOrRunBuilder hero(Hero hero){
        this.hero = hero;
        return this;
    }

    public FightOrRunBuilder vilain(Vilain vilain){
        this.vilain = vilain;
        return this;
    }

    public FightOrRunBuilder question(Question question){
        this.question = question;
        return this;
    }

    public FightOrRun build(){
        FightOrRun fightOrRun = new FightOrRun(this);
        return fightOrRun;
    }
}
