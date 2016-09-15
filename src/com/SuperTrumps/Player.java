package com.SuperTrumps;

import java.util.ArrayList;

public class Player {

    private static final int STARTING_HAND = 8;
    String playerName;

    ArrayList<Card> Hand = new ArrayList<>();

    //Deals 8 cards to player and removes 8 from deck
    public void DealHand(Player player, Deck cardDeck) {
        for (int i = 0; i < STARTING_HAND; i++) {
            player.Hand.add(cardDeck.deckArray.get(cardDeck.size()-1));
            cardDeck.deckArray.remove(cardDeck.deckArray.get(cardDeck.size()-1));
        }
    }

    //Adds card to player hand and removes from deck
    public void DrawCard(Player player, Deck cardDeck) {
        player.Hand.add(cardDeck.deckArray.get(cardDeck.size()-1));
        cardDeck.deckArray.remove(cardDeck.deckArray.get(cardDeck.size()-1));
    }

    //Removes one card from hand to go into play
    public void PlayCard(Player player, int cardToPlay) {
        System.out.println("Playing the card: \n" + player.Hand.get(cardToPlay-1));
        player.Hand.remove(player.Hand.get(cardToPlay -1));
    }


}
