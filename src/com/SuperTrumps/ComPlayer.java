package com.SuperTrumps;

import java.util.Random;

public class ComPlayer extends Player {

    ComPlayer(int playerID){
        this.playerID = playerID;
    }

    public Card getComCardToPlay(Player comPlayer, int randCard) {
        return comPlayer.Hand.get(randCard);
    }

    public int getRandCard(Player comPlayer) {
        Random randCard = new Random();
        return randCard.nextInt(comPlayer.Hand.size() - 1 ) + 1;
    }

    public int getCategoryFromComPlayer() {
        Random randCategory = new Random();
        return randCategory.nextInt(5)+1;
    }

    public int playCardOrPass(Player comPlayer, int categoryInt, int valueInPlay, Deck cardDeck){
        Card cardToPlay;
        int cardNum = 0;
        int valueToPlay = 0;

        for (int i = 0; i < Hand.size(); i++) {
            cardToPlay = Hand.get(i);
            valueToPlay = Game.getValueToPlay(categoryInt, cardToPlay.getCategoryInPlay(categoryInt));
            if (valueToPlay >= valueInPlay) {
                cardNum = i + 1;
                return cardNum;
            }
        }return cardNum;
    }
}
