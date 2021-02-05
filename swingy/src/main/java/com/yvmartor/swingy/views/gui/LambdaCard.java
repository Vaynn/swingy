package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.Swingy;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class LambdaCard extends JPanel{
    public  JPanel container = new JPanel();
    public  Font fontmini = new Font("Courier", Font.PLAIN, 15);


    public void addStatLabel(JPanel container, Font font, String statName, String statValue){
        JLabel label = new JLabel();
        label.setText(statName + statValue);
        label.setForeground(Color.white);
        label.setFont(font);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));
        container.add(label);
    }

    public JPanel getLambdaCard(String pics, String a, String b){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.BLACK);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream(pics);
        try {
            Image image = ImageIO.read(resourceAsStream);
            JLabel label1 = new JLabel(new ImageIcon(image));

            this.add(label1);
        } catch (IOException e){
            ConsoleStringColor.error("LAMBDA CARD: IMPOSSIBLE TO FIND THE PICTURE");
        }
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.BLACK);
        addStatLabel(container, fontmini, a,  b);
        this.add(container);
        return this;
    }

}
