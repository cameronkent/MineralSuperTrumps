package com.SuperTrumps.GUI;

import com.SuperTrumps.Game;

public class run {

    static Game gameST;
    static GUI newApp;

    public static void main(String[] args) {

        newApp = new GUI();
        newApp.buildFrame();
        newApp.buildWelcomePanel();
        newApp.buildSetupPanel();

        GUI.game_Frame.setContentPane(GUI.welcome_panel);


    }

    public static void runGame() {
        gameST = new Game((int) GUI.numPlayers_comboBox.getSelectedItem());
        gameST.setUserPlayer(GUI.name_textField.getText());
        gameST.setComPlayers();
        try { gameST.buildCardDeck();
        } catch (Exception e) {e.printStackTrace();}
        gameST.randomiseDealer();
        gameST.dealPlayerHands();
        //todo: add status message

        newApp.buildGameTablePanel();
        GUI.game_Frame.setContentPane(GUI.gameTable_panel);
    }
}
