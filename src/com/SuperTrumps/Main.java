package com.SuperTrumps;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        int numPlayers;

//Create Player instance for user and enter user playerName
        UserPlayer userPlayer = new UserPlayer();
        userPlayer.getUserPlayerName();
        System.out.println("Welcome " + userPlayer.playerName);

//Run a Do While loop to get number of players from users
        do {
            Scanner user_input = new Scanner(System.in);
            System.out.println("Choose 2, 3 or 4 computer players. \nHow may opponents:");
            numPlayers = user_input.nextInt();
        }   while (numPlayers <2 || numPlayers >5);
        System.out.println("There are " + (numPlayers + 1) + " players in this game.");

//Create array of comPlayers using ComPlayer class
        ComPlayers[] comPlayer = new ComPlayers[numPlayers];
        for (int i = 0; i < comPlayer.length; i++) {
            comPlayer[i] = new ComPlayers();
            comPlayer[i].comPlayerName = "Computer " + (Integer.toString(i + 1));
        }

//Display names of player and computer players
        System.out.println("This games players are:");
        System.out.println(userPlayer.playerName);
        for (int i = 0; i < comPlayer.length; i++) System.out.println(comPlayer[i].comPlayerName);

//Build a deck from plist and shuffle
        Deck cardDeck = new Deck();
        Collections.shuffle(cardDeck.deckArray);
        System.out.println("The deck has been shuffled. \nThere are " + cardDeck.size() + " Mineral and SuperTrump cards.");

//Deal 8 cards to all players
        userPlayer.DealHand(userPlayer, cardDeck);
        for (int j = 0; j < comPlayer.length; j++) comPlayer[j].DealHand(comPlayer[j], cardDeck);
        System.out.println("The hands have been dealt. \nThere are " + cardDeck.size() + " cards remaining.");

//Displays users hand
        userPlayer.showHand(userPlayer);
    }
}
