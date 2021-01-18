package com.yvmartor.swingy.models.scenario.fight_or_run;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.scenario.question.Question;
import com.yvmartor.swingy.models.villains.Villain;

public class FightOrRunBuilder {
    Hero hero;
    Villain villain;
    Question question;

    public FightOrRunBuilder hero(Hero hero){
        this.hero = hero;
        return this;
    }

    public FightOrRunBuilder vilain(Villain villain){
        this.villain = villain;
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
