package com.SuperTrumps;

import java.util.ArrayList;

public class Player {

    String playerName;

    ArrayList<Card> Hand = new ArrayList<>();

    public void DealHand(Player player, Deck cardDeck) {
        for (int i = 0; i < 8; i++) {
            player.Hand.add(cardDeck.deckArray.get(cardDeck.size()-1));
            cardDeck.deckArray.remove(cardDeck.deckArray.get(cardDeck.size()-1));
        }
    }

    public void DrawCard(Player player, Deck cardDeck) {
        player.Hand.add(cardDeck.deckArray.get(cardDeck.size()-1));
        cardDeck.deckArray.remove(cardDeck.deckArray.get(cardDeck.size()-1));
    }
}
