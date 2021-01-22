package com.yvmartor.swingy.views.gui;

import javax.swing.*;
import java.awt.*;


public class CreateMapFrame {
    JFrame mapFrame;
        public CreateMapFrame() {
            this.mapFrame= new JFrame();
            this.mapFrame = mapFrame;
            this.mapFrame.setSize(500, 500);
            this.mapFrame.setTitle("Swingy Map");
            this.mapFrame.setLocationRelativeTo(null);
            this.mapFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            this.mapFrame.setVisible(false);
        };

    public JFrame getMapFrame() {
        return mapFrame;
    }
}
