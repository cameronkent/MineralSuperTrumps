package com.SuperTrumps.Testing;

import java.util.Random;
import java.util.Scanner;

public class TestThree {
    public static void main(String[] args) {

        System.out.println("numPlayers:");
        Scanner input_numPlayers = new Scanner(System.in);
        int numPlayers = input_numPlayers.nextInt();

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int dealer = random.nextInt(numPlayers + 1) + 1;
            System.out.println(dealer);
        }
        System.out.println("second");
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int dealer = random.nextInt(numPlayers + 1) + 1;
            System.out.println(dealer);
        }
    }
}
