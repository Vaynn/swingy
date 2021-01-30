package com.yvmartor.swingy.models.scenario.gui_fight_telling;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;

public class GuiFightTelling {
    private WorldMap worldMap;
    private Villain villain;
    private JFrame mainFrame;

    public GuiFightTelling(WorldMap worldMap, Villain villain, JFrame mainFrame){
        this.worldMap = worldMap;
        this.villain = villain;
        this.mainFrame = mainFrame;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public Villain getVillain() {
        return villain;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void setVillain(Villain villain) {
        this.villain = villain;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
