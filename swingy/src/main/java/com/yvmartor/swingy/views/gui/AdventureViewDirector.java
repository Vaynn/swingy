package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.hero.HeroBuilder;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

public class AdventureViewDirector {

    private AdventureViewBuilder adventureViewBuilder;

    public void setAdventureViewBuilder(AdventureViewBuilder adventureViewBuilder) {
        this.adventureViewBuilder = adventureViewBuilder;
    }

    public AdventureView getAdventureView(){
        return adventureViewBuilder.getAdventureView();
    }

    public void constructAdventure(WorldMap worldmap, String ask, Villain villain){
        adventureViewBuilder.createNewHero();
        adventureViewBuilder.buildContainer();
        adventureViewBuilder.buildTitle();
        adventureViewBuilder.buildActionButtons();
        adventureViewBuilder.buildAsk(ask);
        adventureViewBuilder.buildHeroMiniCard(worldmap);
        adventureViewBuilder.buildVillainMiniCard(villain);
        adventureViewBuilder.buildImage();

    }
}
