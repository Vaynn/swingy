package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.Swingy;
import com.yvmartor.swingy.models.villains.Villain;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class LambdaCard extends JPanel{
    public static JPanel container = new JPanel();
    public static JPanel card = new JPanel();
    public static  Font fontmini = new Font("Courier", Font.PLAIN, 15);


    public static void addStatLabel(JPanel container, Font font, String statName, String statValue){
        JLabel label = new JLabel();
        label.setText(statName + statValue);
        label.setForeground(Color.white);
        label.setFont(font);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));
        container.add(label);
    }

    public static JPanel getLambdaCard(String pics, String a, String b){
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.BLACK);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream(pics);
        try {
            Image image = ImageIO.read(resourceAsStream);
            JLabel label1 = new JLabel(new ImageIcon(image));

            card.add(label1);
        } catch (IOException e){
            System.err.println(e);
        }
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.BLACK);
        addStatLabel(container, fontmini, a,  b);
        card.add(container);
        return card;
    }

}
