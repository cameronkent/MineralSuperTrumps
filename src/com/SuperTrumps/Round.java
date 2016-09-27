package com.SuperTrumps;


public class Round {

    public Card getCardInPlay(int playerToStart, UserPlayer userPlayer, ComPlayer comPlayer) {
        Card cardInPlay = null;
        switch (playerToStart) {
            case 0:
                userPlayer.showHand(userPlayer);
                int cardToPlay = userPlayer.getCardToPlay();
                cardInPlay = userPlayer.PlayCard(userPlayer, cardToPlay);
                break;
            case 1:
                cardInPlay = comPlayer.getComCardToPlay(comPlayer, comPlayer.getRandCard(comPlayer));
                break;
            case 2:
//                cardInPlay = comPlayer.playCard(comPlayer[1], comPlayer.getRandCard);
                break;
            case 3:
//                cardInPlay = comPlayer.playCard(comPlayer[2], comPlayer.getRandCard);
                break;
            case 4:
//                cardInPlay = comPlayer.playCard(comPlayer[3], comPlayer.getRandCard);
                break;
        } return cardInPlay;
    }

    public int getCategory(int playerToStart, UserPlayer userPlayer, ComPlayer comPlayer) {
        int categoryNumber;
        if (playerToStart == 0) {
            categoryNumber = userPlayer.getCategoryToPlay();
        }else {
            categoryNumber = comPlayer.getCategoryFromComPlayer();
        }
        return categoryNumber;
    }
}
