package com.SuperTrumps;

import java.util.Scanner;

public class UserPlayer extends Player {


    UserPlayer() {
        playerID = 0;
    }

    //Take input to set name of player
    String getUserPlayerName() {
        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter your name:");
        return playerName = user_input.next();
    }

    //Displays users hand
    public void showHand(Player player) {
        System.out.println("Cards in hand " + player.Hand.size());
        for (int i = 0; i < player.Hand.size(); i++ )System.out.println("Card #" + (i+1) + ":\n" + player.Hand.get(i));
    }

    //Take input to play card from users hand
    public Card getCardToPlay(Player userPlayer) {
        Scanner inputCardToPlay = new Scanner(System.in);
        System.out.println("Choose card to play");
        Card cardInPlay = userPlayer.PlayCard(userPlayer, inputCardToPlay.nextInt());
        return cardInPlay;
    }

    public int getCategoryToPlay() {
        int categorySelect;
        System.out.println("Choose category to play:" + "\n1 Hardness" + "\n2 Specific gravity" + "\n3 Cleavage" + "\n4 Crustal abundance" + "\n5 Economic value");
        Scanner inputCategory = new Scanner(System.in);
        categorySelect = inputCategory.nextInt();
        return categorySelect;
    }
}
