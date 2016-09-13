package com.SuperTrumps;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        int numPlayers;

//Create Player instance for user and enter user playerName
        UserPlayer userPlayer = new UserPlayer();
        String playerName = userPlayer.getUserPlayerName();

        System.out.println("Welcome " + playerName);

//Run a Do While loop to get number of players from users
        do {
            Scanner user_input = new Scanner(System.in);
            System.out.println("Choose 2,3 or 4 computer players.");
            System.out.println("How may opponents:");
            numPlayers = user_input.nextInt();
        }   while (numPlayers <2 || numPlayers >5);

        System.out.println("There are " + (numPlayers + 1) + " players in this match.");

//Create array of comPlayers using ComPlayer class
        ComPlayers[] compPlayer = new ComPlayers[numPlayers];

        for (int i = 0; i < compPlayer.length; i++) {
            compPlayer[i] = new ComPlayers();
            compPlayer[i].compPlayerName = "Computer " + (Integer.toString(i + 1));
        }

//Display names of player and computer players
        System.out.println("This games players are:");
        System.out.println(playerName);
        for (int i = 0; i < compPlayer.length; i++) {
            System.out.println(compPlayer[i].compPlayerName);
        }
//NEED TO CREATE METHOD CALL TO DEAL HANDS
//Build a deck from plist and shuffle
        Deck cardDeck = new Deck();
        Collections.shuffle(cardDeck.deckArray);
        System.out.println("The deck has been shuffled. \nThere are " + cardDeck.size() + " Mineral and SuperTrump cards.");


//Deal 8 cards to a player hand
        for (int i = 0; i < 8; i++) {
            int deckSize = cardDeck.size();
            userPlayer.Hand.add(cardDeck.deckArray.get(deckSize-1));
            cardDeck.deckArray.remove(cardDeck.deckArray.get(deckSize-1));
        }

//Deal 8 cards to each comPlayer
        for (int j = 0; j < compPlayer.length; j++) {
            for (int i = 0; i < 8; i++) {
                int deckSize = cardDeck.size();
                compPlayer[j].Hand.add(cardDeck.deckArray.get(deckSize-1));
                cardDeck.deckArray.remove(cardDeck.deckArray.get(deckSize-1));
            }
        }
        System.out.println("The hands have been dealt. \nThere are " + cardDeck.size() + " cards remaining.");


    }

}
