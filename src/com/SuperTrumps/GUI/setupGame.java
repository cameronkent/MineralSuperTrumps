package com.SuperTrumps.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cameronkent on 5/10/2016.
 */
public class setupGame {
    public JPanel panel_setupGame;
    private JLabel label_setupGame;
    private JButton button_startGame;
    private JButton button_backToMain;
    private JTextField text_getUserName;
    private JLabel label_userName;
    private JLabel label_numPlayers;
    private JComboBox combo_numPlayers;

    public setupGame() {
        button_backToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_setupGame.setVisible(false);
                GUI.setFrameHome();
            }
        });
    }
}
