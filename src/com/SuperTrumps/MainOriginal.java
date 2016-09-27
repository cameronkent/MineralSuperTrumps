package com.SuperTrumps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainOriginal {

    public static void main(String[] args) throws Exception {

        int numPlayers;
        int categoryNumber;
        //Game newGame = new Game();
        String categoryAsString;
        String categoryValueAsString;
        Card cardInPlay;
        int randCardToPlay;
        Card cardToPlay;
        int valueInPlay;
        int valueToPlay;

//Create Player instance for user and enter user playerName
        UserPlayer userPlayer = new UserPlayer();
        userPlayer.getUserPlayerName();
        System.out.println("Welcome " + userPlayer.playerName);

//Run a Do While loop to get number of players from users
        do {
            Scanner user_input = new Scanner(System.in);
            System.out.println("Choose 2, 3 or 4 computer players. \nHow may opponents:");
            numPlayers = user_input.nextInt();
        } while (numPlayers < 2 || numPlayers > 5);
        System.out.println("There are " + (numPlayers + 1) + " players in this game.");
        ArrayList[] turnOrder = new ArrayList[numPlayers];

//Create array of comPlayers using ComPlayer class
        ComPlayer[] comPlayer = new ComPlayer[numPlayers];
        for (int i = 0; i < comPlayer.length; i++) {
            comPlayer[i] = new ComPlayer(i + 1);
            comPlayer[i].playerName = "Computer " + (Integer.toString(i + 1));
        }

//Display names of player and computer players
        System.out.println("This games players are:");
        System.out.println(userPlayer.playerName);
        for (int i = 0; i < comPlayer.length; i++) System.out.println(comPlayer[i].playerName);

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

//Turn structure with user playing first card
//        cardInPlay = userPlayer.getCardToPlay(userPlayer);
        categoryNumber = userPlayer.getCategoryToPlay();
        //categoryAsString = newGame.getCategoryAsString(categoryNumber);

//        categoryValueAsString = cardInPlay.getCategoryInPlay(categoryNumber);

//        valueInPlay = Game.getValueToPlay(categoryNumber, categoryValueAsString);
        //System.out.println("Category for this round is: " + categoryAsString.toUpperCase());
//        System.out.println("Score to beat is: " + categoryValueAsString);

////ComPlayers play or pass
//        for (int i = 0; i < comPlayer.length; i++) {
//            int comMove = comPlayer[i].playCardOrPass(comPlayer[i], categoryNumber, valueInPlay, cardDeck);
//            if (comMove == 0) {
//                comPlayer[i].DrawCard(comPlayer[i], cardDeck);
//            } else {
//                comPlayer[i].PlayCard(comPlayer[i], i+1);
//            }
//        }
    }
}
