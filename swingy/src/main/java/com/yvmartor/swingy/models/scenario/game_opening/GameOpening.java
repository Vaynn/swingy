package com.yvmartor.swingy.models.scenario.game_opening;

import com.yvmartor.swingy.models.artefacts.WeaponBuilder;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;

public class GameOpening {
    private String title;
    private ArrayList<String> options;
    private String image;

    GameOpening(GameOpeningBuilder builder){
        this.title = builder.title;
        this.options = builder.options;
        this.image = builder.image;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
