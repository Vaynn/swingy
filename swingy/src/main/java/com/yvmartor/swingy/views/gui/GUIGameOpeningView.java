package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.Swingy;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GUIGameOpeningView extends JFrame {

    JPanel container = new JPanel();
    JFrame frame;
    ArrayList<JButton> action = new ArrayList<JButton>();

    public void printGameOpening(JFrame myFrame, String title, ArrayList<String> options, String image) throws IOException{
        frame = myFrame;

        container.setLayout(new BorderLayout(5, 5));
        container.setBackground(Color.BLACK);
        container.setBorder(new EmptyBorder(0, 0, 300, 0));

        InputStream resourceAsStream = Swingy.class.getResourceAsStream(image);
        Image landscape = ImageIO.read(resourceAsStream);
        JLabel label1 = new JLabel(new ImageIcon(landscape));
        container.add(label1, BorderLayout.CENTER);

        JLabel gameTitle = new JLabel(title);
        gameTitle.setText(title);
        gameTitle.setForeground(Color.cyan);
        Font gameTitleFont = new Font("Courier", Font.BOLD, 50);
        gameTitle.setFont(gameTitleFont);
        gameTitle.setHorizontalAlignment(JLabel.CENTER);
        gameTitle.setVerticalAlignment(JLabel.CENTER);
        gameTitle.setBorder(new EmptyBorder(20, 0, 50, 0));
        container.add(gameTitle, BorderLayout.NORTH);

        JPanel actionButtons = new JPanel(new GridBagLayout());
        actionButtons.setBackground(Color.BLACK);
        actionButtons.setSize(100,100);
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < options.size(); i++) {
            action.add(new JButton(options.get(i)));
        }
        //New Hero
        c.gridx = 2;
        c.gridy = 1;
        actionButtons.add(action.get(1), c);

        //CONTINUE HERO
        c.gridx = 0;
        c.gridy = 1;
        actionButtons.add(action.get(0), c);

        container.add(actionButtons, BorderLayout.SOUTH);

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.removeAll();
        contentPane.add(container);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public ArrayList<JButton> getAction() {
        return action;
    }
}
