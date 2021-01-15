package com.yvmartor.swingy.models.scenario.fight_or_run;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.adventure.AdventureBuilder;
import com.yvmartor.swingy.models.scenario.question.Question;
import com.yvmartor.swingy.models.vilains.Vilain;

import java.util.ArrayList;

public class FightOrRun {
    private Hero hero;
    private Vilain vilain;
    private Question question;

    public FightOrRun(FightOrRunBuilder builder){
        this.hero = builder.hero;
        this.vilain = builder.vilain;
        this.question = builder.question;
    }

    public Hero getHero() {
        return hero;
    }

    public Vilain getVilain() {
        return vilain;
    }

    public Question getQuestion() {
        return question;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setVilain(Vilain vilain) {
        this.vilain = vilain;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
