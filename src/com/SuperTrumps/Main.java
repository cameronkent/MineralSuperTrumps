package com.SuperTrumps;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean gameOver = false;

//  Start application
        System.out.println("Welcome to Mineral SuperTrumps!");

//  Edit player name
        Scanner input_playerName = new Scanner(System.in);
        System.out.println("Enter your name:");
        String playerName = input_playerName.next();
        System.out.println("Welcome " + playerName + "\n");


//  Choose number of players
        int numPlayers;
        do {Scanner input_numPlayers = new Scanner(System.in);
            System.out.println("Choose 2, 3 or 4 computer players. \nHow may opponents:");
            numPlayers = input_numPlayers.nextInt();
        }   while (numPlayers <2 || numPlayers >5);
        System.out.println("There are " + ((numPlayers)  + 1) + " players in this game.");

//  Start new game
        Game gameST = new Game(numPlayers);
        gameST.setUserPlayer(playerName);

//  Add players
        gameST.setComPlayers();
        gameST.showPlayers();

        //input check before starting rounds
        boolean playReady = false;
        do {
            System.out.println("\nAre you ready to play? y/n");
            Scanner input_playReady = new Scanner(System.in);
            if (input_playReady.next().charAt(0) == 'y') {
                System.out.println("\nGAME STARTING\n");
                playReady = true; }
        } while (playReady == false);

        gameST.randomiseDealer();

        gameST.buildCardDeck();

        gameST.dealPlayerHands();

        do {
            gameST.playGameRound();
            System.out.println("Round complete");
        } while (gameOver = false);

//  If player plays 'Trump' card round is over

//  New round category is the 'Trump' category

//  Player who played 'Trump' begins next round

//  Rounds continue

//  First player with empty hand wins game


    }
}
