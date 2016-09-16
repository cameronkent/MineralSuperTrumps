package com.SuperTrumps;

import java.util.Random;

public class ComPlayer extends Player {

    String comPlayerName;

    public Card getComCardToPlay(Player comPlayer) {
        Random random = new Random();
        int randCard = random.nextInt(comPlayer.Hand.size() - 1 + 1) + 1;
        Card cardInPlay = comPlayer.PlayCard(comPlayer, randCard);
        return cardInPlay;
    }
}
