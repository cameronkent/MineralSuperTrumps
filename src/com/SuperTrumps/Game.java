package com.SuperTrumps;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Game {

    private int numPlayers;
    private UserPlayer userPlayer;
    private ComPlayer[] comPlayer;
    private Deck cardDeck;
    private int dealer;
    private Array[] playerTurn = new Array[numPlayers];
    private String categoryAsString;
    private int categorySelect;
    private String categoryValueAsString;
    private int valueToPlay;
    private String categoryInPlay;

    //Create Player instance for user and enter user playerName
    public void setUserPlayer() {
        userPlayer = new UserPlayer();
        userPlayer.getUserPlayerName();
        System.out.println("Welcome " + userPlayer.playerName);
    }

    //Run a Do While loop to get number of players from users
    public void setNumPlayers() {
        do {
            Scanner user_input = new Scanner(System.in);
            System.out.println("Choose 2, 3 or 4 computer players. \nHow may opponents:");
            numPlayers = user_input.nextInt();
        }   while (numPlayers <2 || numPlayers >5);
        System.out.println("There are " + ((numPlayers)  + 1) + " players in this game.");
    }

    //Create array of comPlayers using ComPlayer class
    public void setComPlayers() {
        for (int i = 0; i < numPlayers; i++) {
            comPlayer[i] = new ComPlayer();
            comPlayer[i].comPlayerName = "Computer " + (Integer.toString(i + 1));
        }
    }

    //Display names of player and computer players
    public void showPlayers() {
        System.out.println("This games players are:");
        System.out.println(userPlayer.playerName);
        for (int i = 0; i < comPlayer.length; i++) {
            System.out.println(comPlayer[i].comPlayerName);
        }
    }

    //Build a deck from plist and shuffle
    public void buildCardDeck() throws Exception {
        cardDeck = new Deck();
        Collections.shuffle(cardDeck.deckArray);
        System.out.println("The deck has been shuffled. \nThere are " + cardDeck.size() + " Mineral and SuperTrump cards.");
    }

    //Create a random int to 'select' dealer
    public void randomiseDealer() {
        Random random = new Random();
        dealer = random.nextInt(numPlayers - 1 + 1) + 1;
        if (dealer == 1) {
            System.out.println(userPlayer.playerName + " is dealing this round");
        }else {
            System.out.println(comPlayer[dealer] + " is dealing this round");
        }
    }

    //Deal 8 cards to all players
    public void dealPlayerHands() {
        userPlayer.DealHand(userPlayer, cardDeck);
        for (int j = 0; j < comPlayer.length; j++) comPlayer[j].DealHand(comPlayer[j], cardDeck);
        System.out.println("The hands have been dealt. \nThere are " + cardDeck.size() + " cards remaining.");
    }

    public void startNewRound() {
        userPlayer.showHand(userPlayer);
        userPlayer.getCardToPlay(userPlayer);
        categorySelect = userPlayer.getCategoryToPlay();
        Card test = comPlayer[1].getComCardToPlay(comPlayer[1]);
        System.out.println(test);
    }

    //Return a string of category for printing
    public String getCategoryAsString(int categorySelect ) {
        String categoryAsString;
        loop: do {
            switch (categorySelect) {
                case 1: categoryAsString = "Hardness";
                    break loop;
                case 2: categoryAsString = "Specific gravity";
                    break loop;
                case 3: categoryAsString = "Cleavage";
                    break loop;
                case 4: categoryAsString = "Crustal abundance";
                    break loop;
                case 5: categoryAsString = "Economic value";
                    break loop;
                default: categoryAsString = "";
                    break;
            }
        } while (categoryAsString.equals(""));
        return categoryAsString;
    }

}
