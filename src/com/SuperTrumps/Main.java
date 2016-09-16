package com.SuperTrumps;

import com.sun.xml.internal.bind.v2.TODO;

public class Main {

    public static void main(String[] args) throws Exception {

//Create new game instance
        Game newGame = new Game();

//Create players and display names and number of players
        newGame.setUserPlayer();
        newGame.setNumPlayers();
        newGame.setComPlayers();
        newGame.showPlayers();

//Build a deck instance, shuffle deck, display random dealer and deal each player a hand
        newGame.buildCardDeck();
        newGame.randomiseDealer();
        newGame.dealPlayerHands();

        // TODO: 16/09/16 set dealer to be fluid
//Player 'left' of dealer begins game by playing first card
        newGame.startNewRound();
    }
}
