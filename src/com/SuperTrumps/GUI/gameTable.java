package com.SuperTrumps.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cameronkent on 6/10/2016.
 */
public class gameTable {
    public JPanel panel_gameTable;
    private JLabel label_comPlayer1;
    private JLabel label_comPlayer2;
    private JLabel label_comPlayer3;
    private JLabel label_comPlayer4;
    private JLabel label_userPlayer;
    private JPanel userPLayerHand;
    private JPanel comPlayer3Hand;
    private JPanel comPlayer1Hand;
    private JPanel comPlayer2Hand;
    private JPanel comPlayer4Hand;
    private JPanel deck;
    private JPanel cardInPlay;
    private JButton quitGameButton;
    private JButton playButton;
    private JButton passButton;
    private JLabel label_deck;
    private JLabel label_cardInPlay;

    public gameTable() {
        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_gameTable.setVisible(false);
                GUI.setFrameHome();
            }
        });
    }
}
