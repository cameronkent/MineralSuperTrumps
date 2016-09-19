package com.SuperTrumps;

import java.util.Random;

public class ComPlayer extends Player {

    public Card getComCardToPlay(Player comPlayer, int randCard) {
        return comPlayer.Hand.get(randCard);
    }

    public int getRandCard(Player comPlayer) {
        Random randCard = new Random();
        return randCard.nextInt(comPlayer.Hand.size() - 1 + 1) + 1;
    }
}
