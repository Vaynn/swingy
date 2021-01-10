package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.hero.Hero;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class GUISelectHeroView extends JFrame {


    public void printSelectHeroView(JFrame myFrame, String title, ArrayList<Hero> heroesList) throws IOException {
        JTabbedPane heroTab = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        for (int i=0; i < heroesList.size(); i++){
            Hero hero = heroesList.get(i);
            heroTab.addTab(hero.getName(), new HeroCard(hero).getHeroCard());
        }
        JPanel contentPane = (JPanel) myFrame.getContentPane();
        contentPane.removeAll();
        contentPane.add(heroTab);
        contentPane.revalidate();
        contentPane.repaint();
    }
}
