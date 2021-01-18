package com.yvmartor.swingy.models.scenario.fight_or_run;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.scenario.question.Question;
import com.yvmartor.swingy.models.villains.Villain;

public class FightOrRun {
    private Hero hero;
    private Villain villain;
    private Question question;

    public FightOrRun(FightOrRunBuilder builder){
        this.hero = builder.hero;
        this.villain = builder.villain;
        this.question = builder.question;
    }

    public Hero getHero() {
        return hero;
    }

    public Villain getVilain() {
        return villain;
    }

    public Question getQuestion() {
        return question;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setVilain(Villain villain) {
        this.villain = villain;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
