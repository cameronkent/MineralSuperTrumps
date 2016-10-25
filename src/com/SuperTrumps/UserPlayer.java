package com.SuperTrumps;

import com.SuperTrumps.GUI.MainUI;

import java.util.Scanner;

public class UserPlayer extends Player {

    static public int cardNumber;
    private int category;

    UserPlayer() {}

    UserPlayer(String playerName) {
        playerID = 0;
        this.playerName = playerName;
    }

//    //Take input to set name of player
//    String getUserPlayerName() {
//        Scanner user_input = new Scanner(System.in);
//        System.out.println("Enter your name:");
//        return playerName = user_input.next();
//    }

    //Displays users hand
//    public void showHand(Player player) {
//        String showHandChoice;
//        do {
//            Scanner input_showHand = new Scanner(System.in);
//            System.out.println("View hand? y/n");
//            showHandChoice = input_showHand.next();
//            if (showHandChoice.charAt(0) == 'y') {
//                System.out.println("Cards in hand " + player.Hand.size());
//                for (int i = 0; i < player.Hand.size(); i++)
//                    System.out.println("Card #" + (i + 1) + ":\n" + player.Hand.get(i));
//            }
//        } while (showHandChoice.charAt(0) != 'y');
//    }

    public void setCardToPlay(int i) {
        cardNumber = i+1;
    }

    public int getCardToPlay() { // TODO: 21/10/2016 alter for UI input
        return cardNumber;
    }

    public int getCategoryToPlay() { // TODO: 21/10/2016 alter for UI input
//        MainUI.addMessageLabel("Choose category to play");
//        MainUI.categoryPanel.setVisible(true);
        return category;
    }

    public int playOrPass() { // TODO: 21/10/2016 work UI around this method
        int playOrPass;
        Scanner input_playOrPass = new Scanner(System.in);
        do {
            MainUI.addMessageLabel("Play a card or Pass turn");
            playOrPass = input_playOrPass.nextInt();
        } while (playOrPass != 1 && playOrPass != 2);
        return playOrPass;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}