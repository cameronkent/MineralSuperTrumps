package com.SuperTrumps.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcomeGUI {
    private JButton button_newGame;
    public JPanel panel_welcome;
    private JLabel label_welcome;
    private JButton button_viewRules;
    private JLabel label_infoText;


    public welcomeGUI() {
        button_newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_welcome.setVisible(false);
                GUI.setFrameSetupGame();
            }
        });
    }
}
