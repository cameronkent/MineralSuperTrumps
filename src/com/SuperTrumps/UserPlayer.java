package com.SuperTrumps;

import java.util.Scanner;

public class UserPlayer extends Player {

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

}
