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

    public void PlayCard(Player player, int cardToPlay) {
        System.out.println("Playing the card: \n" + player.Hand.get(cardToPlay-1));
        player.Hand.remove(player.Hand.get(cardToPlay -1));
    }

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
