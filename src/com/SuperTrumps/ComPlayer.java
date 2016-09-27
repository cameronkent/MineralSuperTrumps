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

    public Card PlayCard(Player player, int cardToPlay) {
        System.out.println(playerName + " is playing the card: \n" + player.Hand.get(cardToPlay-1));
        Card cardInPlay = player.Hand.get(cardToPlay - 1);
        player.Hand.remove(player.Hand.get(cardToPlay -1));
        return cardInPlay;
    }

    public int getCategoryFromComPlayer() {
        Random randCategory = new Random();
        return randCategory.nextInt(5)+1;
    }

    public int playCardOrPass(int categoryInt, int valueInPlay){
        Card cardToPlay;
        int cardNum = 0;
        int valueToPlay;

        for (int i = 0; i < Hand.size(); i++) {
            cardToPlay = Hand.get(i);
            valueToPlay = Game.getValueToPlay(categoryInt, cardToPlay.getCategoryInPlay(categoryInt));
            if (valueToPlay > valueInPlay) {
                cardNum = i + 1;
                return cardNum;
            }
        }return cardNum;
    }
}
