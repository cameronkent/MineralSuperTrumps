package com.SuperTrumps;

import java.util.Scanner;

public class UserPlayer extends Player {

    String playerName = "";

    String getUserPlayerName() {

        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter your name:");
        playerName = user_input.next();
        return playerName;
    }

}
