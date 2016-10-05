package com.SuperTrumps;

import java.util.Scanner;

public class Main {

    static boolean gameOver;

    public static void main(String[] args) throws Exception {
        boolean playReady = false;

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
        do {
            System.out.println("\nAre you ready to play? y/n");
            Scanner input_playReady = new Scanner(System.in);
            if (input_playReady.next().charAt(0) == 'y') {
                System.out.println("\n**************************************************\n" +
                                   "                  GAME STARTING" +
                                   "\n**************************************************\n");
                playReady = true; }
        } while (!playReady);

        gameST.randomiseDealer();

        gameST.buildCardDeck();

        gameST.dealPlayerHands();

        do {
            System.out.println("\n**************************************************\n" +
                               "                ROUND (" + (gameST.roundCount +1) +") STARTING" +
                               "\n**************************************************\n");
            System.out.println(gameST.cardDeck.size() + " cards remain in deck");
            gameST.resetPassedPlayers();
            gameST.playGameRound();
            System.out.println("\n**************************************************\n" +
                               "                ROUND (" + gameST.roundCount +") COMPLETE" +
                               "\n**************************************************\n");
        } while (!gameOver);

        System.out.println(gameST.gameWinner.playerName.toUpperCase() + " WINS THE GAME!");
        System.out.println("Thank you for playing!");

    }
}