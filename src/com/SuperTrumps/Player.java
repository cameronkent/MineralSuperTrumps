package com.SuperTrumps;

import java.util.Scanner;

/**
 * Created by cameronkent on 31/08/2016.
 */
public class Player {

    String playerName = "";

    String getPlayerName() {

        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter your name:");
        playerName = user_input.next();
        return playerName;
    }

}
