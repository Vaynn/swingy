package com.yvmartor.swingy.models.scenario.game_opening;

import com.yvmartor.swingy.models.artefacts.Weapon;
import com.yvmartor.swingy.models.artefacts.WeaponBuilder;

import java.util.ArrayList;

public class GameOpeningBuilder {

    String title;
    ArrayList<String> options;
    String image;

    public GameOpeningBuilder title(String title){
        this.title = title;
        return this;
    }

    public GameOpeningBuilder options(ArrayList<String> options){
        this.options = options;
        return this;
    }

    public GameOpeningBuilder image(String image){
        this.image = image;
        return this;
    }

    public GameOpening build(){
        GameOpening gameOpening = new GameOpening(this);
        return gameOpening;
    }
}
