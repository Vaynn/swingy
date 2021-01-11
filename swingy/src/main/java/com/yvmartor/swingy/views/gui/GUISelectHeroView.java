package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.hero.Hero;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class GUISelectHeroView extends JFrame {

    private JLabel titleLabel = new JLabel();
    private JButton selection = new JButton();
    private Font font = new Font("Courier", Font.ITALIC, 35);
    private JTabbedPane heroTab = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

    public void printSelectHeroView(JFrame myFrame, String title, ArrayList<Hero> heroesList) throws IOException {
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout(5, 5));
        container.setBackground(Color.BLACK);
        titleLabel.setText(title);
        titleLabel.setForeground(Color.cyan);
        titleLabel.setFont(font);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setBorder(new EmptyBorder(20, 0, 50, 0));
        container.add(titleLabel, BorderLayout.NORTH);
        
        for (int i=0; i < heroesList.size(); i++){
            Hero hero = heroesList.get(i);
            heroTab.addTab(hero.getName(), new HeroCard(hero).getHeroCard());
        }

        container.add(heroTab, BorderLayout.CENTER);
        selection.setText("SELECT");
        selection.setMargin(new Insets(10,5,10,5));
        container.add(selection, BorderLayout.SOUTH);
        JPanel contentPane = (JPanel) myFrame.getContentPane();
        contentPane.removeAll();
        contentPane.add(container);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public JButton getSelection(){
        return this.selection;
    }

    public JTabbedPane getHeroTab() {
        return heroTab;
    }
}
