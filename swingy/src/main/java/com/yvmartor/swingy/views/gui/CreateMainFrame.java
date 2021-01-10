package com.yvmartor.swingy.views.gui;

import javax.swing.*;
import java.awt.*;

public class CreateMainFrame {

    JFrame myFrame;

    public CreateMainFrame(){
        this.myFrame = new JFrame();
        this.myFrame.setSize(1500, 1000);
        this.myFrame.setBackground(Color.BLACK);
        this.myFrame.setTitle("Swingy");
        this.myFrame.setLocationRelativeTo(null);
        this.myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.myFrame.setVisible(true);
    }

    public JFrame getMyFrame() {
        return myFrame;
    }

}

