package com.yvmartor.swingy.models.scenario.gui_fight_telling;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

public class GuiFightTelling {
    private WorldMap worldMap;
    private Villain villain;

    public GuiFightTelling(WorldMap worldMap, Villain villain){
        this.worldMap = worldMap;
        this.villain = villain;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public Villain getVillain() {
        return villain;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void setVillain(Villain villain) {
        this.villain = villain;
    }
}
