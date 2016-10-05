package com.SuperTrumps;

import java.util.Random;

public class ComPlayer extends Player {

    ComPlayer(int playerID){
        this.playerID = playerID;
    }

    public static int getCategoryFromComPlayer() {
        Random randCategory = new Random();
        return randCategory.nextInt(5)+1;
    }

    public int playCardOrPass(int categoryInt, int valueInPlay){
        Card cardToPlay;
        int cardNum = 0;
        int valueToPlay;

        for (int i = 0; i < Hand.size(); i++) {
            cardToPlay = Hand.get(i);
            if (cardToPlay.isTrump){
                cardNum = i + 1;
                return cardNum;
            }
            valueToPlay = Game.getValueToPlay(categoryInt, cardToPlay.getCategoryValueInPlay(categoryInt));
            if (valueToPlay > valueInPlay) {
                cardNum = i + 1;
                return cardNum;
            }
        }return cardNum;
    }
}