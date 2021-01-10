package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.Swingy;
import com.yvmartor.swingy.models.hero.ChickenHeroBuilder;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.hero.HeroBuilder;
import com.yvmartor.swingy.models.hero.HeroDirector;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GUIGameOpeningView extends JFrame {

    JPanel container = new JPanel();
    JFrame frame;
    private JButton newHero;

    public void printGameOpening(JFrame myFrame, String title, ArrayList<String> options, String image) throws IOException{
        frame = myFrame;
        container.setBackground(Color.BLACK);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(0, 0, 10, 0);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream(image);
        Image landscape = ImageIO.read(resourceAsStream);
        JLabel label1 = new JLabel(new ImageIcon(landscape));
        container.add(label1, constraints);
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        JLabel gameTitle = new JLabel(title);
        gameTitle.setForeground(Color.cyan);
        Font gameTitleFont = new Font("Courier", Font.ITALIC, 70);
        gameTitle.setFont(gameTitleFont);
        container.add(gameTitle, constraints);
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        /*newHero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HeroDirector director = new HeroDirector();
                HeroBuilder chickenHeroBuilder = new ChickenHeroBuilder();
                director.setHeroBuilder(chickenHeroBuilder);
                director.constructHero();
                Hero hero = director.getHero();
                try {
                    JPanel heroPanel = new HeroCard(hero).getHeroCard();
                    JPanel contentPane = (JPanel) myFrame.getContentPane();
                    contentPane.removeAll();
                    contentPane.add(heroPanel);
                    contentPane.revalidate();
                    contentPane.repaint();
                }
                catch (IOException ex){
                    System.err.println(ex);
                }
            }
        });*/
        newHero = new JButton(options.get(0));
        container.add(newHero, constraints);
        constraints.gridx = 4;
        constraints.gridy = 5;
        JButton existingHero = new JButton(options.get(1));
        container.add(existingHero, constraints);
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.removeAll();
        contentPane.add(container);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public JButton getNewHero() {
        return newHero;
    }
}
