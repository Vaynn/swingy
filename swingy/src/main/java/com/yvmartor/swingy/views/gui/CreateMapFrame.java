package com.yvmartor.swingy.views.gui;

import javax.swing.*;


public class CreateMapFrame {
    JFrame mapFrame;
        public CreateMapFrame() {
            this.mapFrame= new JFrame();
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
