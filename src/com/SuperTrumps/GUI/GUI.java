package com.SuperTrumps.GUI;

import javax.swing.*;

public class GUI {

    static public boolean gameOver;
    static public JFrame gameGUI;

    public static void main(String[] args) throws Exception {

        gameGUI = new JFrame("Mineral SuperTrumps");
        gameGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set initial content
        setFrameHome();

        //Set GUI dimensions and visibility
        gameGUI.setSize(800, 600);
        gameGUI.setVisible(true);
        gameGUI.setLocationRelativeTo(null);
        gameGUI.setResizable(false);
    }

    public static void setFrameSetupGame() {
        gameGUI.setContentPane(new setupGame().panel_setupGame);

    }

    public static void setFrameHome() {
        gameGUI.setContentPane(new welcomeGUI().panel_welcome);
    }
}
