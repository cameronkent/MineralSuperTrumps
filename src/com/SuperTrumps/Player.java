package com.SuperTrumps;

import com.SuperTrumps.GUI.MainUI;

import java.util.ArrayList;

public class Player {

    private static final int STARTING_HAND = 8;
    public String playerName;
    int playerID;

    public boolean passedTurn;
    public ArrayList<Card> Hand = new ArrayList<>();

    //Deals 8 cards to player and removes 8 from deck
    public void DealHand(Player player, Deck cardDeck) {
        for (int i = 0; i < STARTING_HAND; i++) {
            player.Hand.add(cardDeck.deckArray.get(cardDeck.size()-1));
            cardDeck.deckArray.remove(cardDeck.deckArray.get(cardDeck.size()-1));
        }
    }

    public Card PlayCard(Player player, int cardToPlay) throws Exception{
        Card cardInPlay = null;
        try {
            MainUI.addMessageLabel(playerName + " is playing the card: \n" + player.Hand.get(cardToPlay - 1));
            cardInPlay = player.Hand.get(cardToPlay - 1);
            player.Hand.remove(player.Hand.get(cardToPlay - 1));
            MainUI.addMessageLabel("Cards in " + this.playerName + " hand " + player.Hand.size());
            return cardInPlay;
        } catch (Exception exc){
            System.out.println("Player.java @ PlayCard");
            exc.printStackTrace();
        } return cardInPlay;
    }

    //Play trump card from Hand
    public Card PlayTrump(Player player, int trumpToPlay) throws Exception{
        Card cardInPlay = null;
        try {
            MainUI.addMessageLabel(playerName + " is playing the TRUMP: \n" + player.Hand.get(trumpToPlay - 1));
            cardInPlay = player.Hand.get(trumpToPlay - 1);
            player.Hand.remove(player.Hand.get(trumpToPlay - 1));
            MainUI.addMessageLabel("Cards in " + this.playerName + " hand " + player.Hand.size());
        } catch (Exception exc) {
            System.out.println("Player.java @ PlayTrump");
            exc.printStackTrace();
        }
        return cardInPlay;
    }

    //Adds card to player hand and removes from deck
    public void DrawCard(Player player, Deck cardDeck) throws Exception{
        try {
            if (cardDeck.size() > 0) {
                MainUI.addMessageLabel(playerName + " draws a card from the deck.\n");
                player.Hand.add(cardDeck.deckArray.get(cardDeck.size() - 1));
                cardDeck.deckArray.remove(cardDeck.deckArray.get(cardDeck.size() - 1));
            } else {
                MainUI.addMessageLabel("Deck is empty.\n");
            }
        } catch (Exception exc) {
            System.out.println("Player.java @ DrawCard");
            exc.printStackTrace();
        }
    }
}