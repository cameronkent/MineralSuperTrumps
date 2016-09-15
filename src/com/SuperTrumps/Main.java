package com.SuperTrumps;

public class Main {

    public static void main(String[] args) throws Exception {

        Game newGame = new Game();

        newGame.setUserPlayer();
        newGame.setNumPlayers();
        newGame.setComPlayers();
        newGame.showPlayers();

        newGame.buildCardDeck();
        newGame.randomiseDealer();
        newGame.dealPlayerHands();

    }
}
