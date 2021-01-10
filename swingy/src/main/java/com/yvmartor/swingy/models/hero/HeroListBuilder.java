package com.yvmartor.swingy.models.hero;

import java.util.ArrayList;

public class HeroListBuilder {

    private final HeroBuilder[] heroTab= {
            new ChickenHeroBuilder(),
            new DogHandlerBuilder(),
            new BlackKnightBuilder(),
            new MadKnightBuilder(),
            new MagicianBuilder(),
            new SaboteurBuilder(),
            new WitchBuilder()
    };

    public ArrayList<Hero> heroListBuilder(){
        ArrayList<Hero> heroList = new ArrayList<Hero>();

        HeroDirector director = new HeroDirector();
        for (int i = 0; i < heroTab.length; i++) {
            HeroBuilder heroBuilder = heroTab[i];
            director.setHeroBuilder(heroBuilder);
            director.constructHero();
            Hero hero = director.getHero();
            heroList.add(hero);
        }
        return heroList;
    }

}
