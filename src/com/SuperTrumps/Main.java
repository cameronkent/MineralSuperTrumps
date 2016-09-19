package com.SuperTrumps;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

//  Start application
        Game gameST = new Game();
        System.out.println("Welcome to Mineral SuperTrumps!");

//  Edit player name
        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter your name:");
        String playerName = user_input.next();


//  Choose number of players
//  Add players
//  Start new game
//  Randomise dealer
//  Deck is shuffled
//  Players dealt 8 cards
//  Remaining cards make up the deck
//  First player plays card to start round
//  Next player plays higher card or passes
//  If player passes they must draw card from deck
//  If player passes they cannot continue in round
//  Player turns continue until one player not passed
//  If player plays 'Trump' card round is over
//  New round category is the 'Trump' category
//  Player who played 'Trump' begins next round
//  Rounds continue
//  First player with empty hand wins game



////Create new game instance
//        Game newGame = new Game();
//
////Create players and display names and number of players
//        newGame.setUserPlayer();
//        newGame.setNumPlayers();
//        newGame.setComPlayers();
//        newGame.showPlayers();
//
////Build a deck instance, shuffle deck, display random dealer and deal each player a hand
//        newGame.buildCardDeck();
//        newGame.randomiseDealer();
//        newGame.dealPlayerHands();
//
//        // TODO: 16/09/16 set dealer to be fluid
////Player 'left' of dealer begins game by playing first card
//        newGame.startNewRound();
    }
}
