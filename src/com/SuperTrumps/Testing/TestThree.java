package com.SuperTrumps.Testing;

import com.SuperTrumps.Deck;
import com.SuperTrumps.Card;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TestThree {
    public static void main(String[] args) throws Exception{

//        Deck testDeck = new Deck();
//        Collections.shuffle(testDeck.deckArray);
//
//        for (int i = 0; i < testDeck.size(); i ++) {
//            Card testCard = testDeck.deckArray.get(i);
//            if ( testCard.isTrump == true) {
//                System.out.println(testCard);
//            }
//        }
        Random randCategory = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(randCategory.nextInt(5) + 1);
        }

//        for (int i = 0; i < 10; i++) {
//            Random random = new Random();
//            Scanner input_numPlayers = new Scanner(System.in);
//            int numPlayers = input_numPlayers.nextInt();
//            int dealer = random.nextInt(numPlayers) + 1;
//            System.out.println(dealer);
//        }
    }

}
