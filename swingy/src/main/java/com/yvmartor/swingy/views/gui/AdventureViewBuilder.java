package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

public abstract class AdventureViewBuilder {

    protected AdventureView adventureView;

    public AdventureView getAdventureView(){
        return adventureView;
    }

    public void createNewHero(){
        adventureView = new AdventureView();
    }

    public abstract void buildContainer();
    public abstract void buildActionButtons();
    public abstract void buildTitle();
    public abstract void buildAsk(String ask);
    public abstract void buildHeroMiniCard(WorldMap worldMap);
    public abstract void buildVillainMiniCard(Villain villain);
    public abstract void buildImage();
}
