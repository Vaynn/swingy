package com.yvmartor.swingy.views.frames;

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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainFrame extends JFrame {

    JPanel container = new JPanel();
    JFrame myFrame = new JFrame();
    private JButton newHero = new JButton("Play with a new hero");
    private JButton existingHero = new JButton("Select one of your hero");
    private JLabel title = new JLabel("Welcome to Swingy");

    public MainFrame() throws IOException{
        container.setBackground(Color.BLACK);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.insets = new Insets(0, 0, 10, 0);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream("/images/landscape.jpg");
        Image image = ImageIO.read(resourceAsStream);
        JLabel label1 = new JLabel(new ImageIcon(image));
        container.add(label1, constraints);
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        title.setForeground(Color.cyan);
        Font titleFont = new Font("Courier", Font.ITALIC, 70);
        title.setFont(titleFont);
        container.add(title, constraints);
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        newHero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HeroDirector director = new HeroDirector();
                HeroBuilder chickenHeroBuilder = new ChickenHeroBuilder();
                director.setHeroBuilder(chickenHeroBuilder);
                director.constructHero();
                Hero hero = director.getHero();
                JPanel heroPanel = new HeroCard(hero).getHeroCard();
                JPanel contentPane = (JPanel) myFrame.getContentPane();
                contentPane.removeAll();
                contentPane.add(heroPanel);
                contentPane.revalidate();
                contentPane.repaint();
            }
        });
        container.add(newHero, constraints);
        constraints.gridx = 4;
        constraints.gridy = 5;
        container.add(existingHero, constraints);
        myFrame.add(container);
        myFrame.setSize(1500, 1000);
        myFrame.setBackground(Color.BLACK);
        myFrame.setTitle("Swingy");
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

}
