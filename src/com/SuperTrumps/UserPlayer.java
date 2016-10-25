package com.SuperTrumps;

import com.SuperTrumps.GUI.MainUI;

import java.util.Scanner;

public class UserPlayer extends Player {

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

    //Take input to play card from users hand
    public int getCardToPlay() { // TODO: 21/10/2016 alter for UI input
        Scanner inputCardToPlay = new Scanner(System.in);
        MainUI.addMessageLabel("Choose card to play");
        int cardToPlay =  inputCardToPlay.nextInt();
        return cardToPlay;
    }

    public int getCategoryToPlay() { // TODO: 21/10/2016 alter for UI input
        int categorySelect;
        MainUI.addMessageLabel("Choose category to play:" + "\n1 Hardness" + "\n2 Specific gravity" + "\n3 Cleavage" + "\n4 Crustal abundance" + "\n5 Economic value");
        Scanner inputCategory = new Scanner(System.in);
        categorySelect = inputCategory.nextInt();
        return categorySelect;
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
}