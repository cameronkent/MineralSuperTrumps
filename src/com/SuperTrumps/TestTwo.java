package com.SuperTrumps;

import java.util.Collections;
import java.util.Scanner;

public class TestTwo {
    public static void main(String[] args) throws Exception {

        //Build and shuffle deck
        System.out.println("creating deck..."); Deck cardDeck = new Deck();
        System.out.println("shuffling deck..."); Collections.shuffle(cardDeck.deckArray);

        //Instantiate user, deal and display hand
        UserPlayer playerOne = new UserPlayer();
        playerOne.DealHand(playerOne, cardDeck);
        playerOne.showHand(playerOne);

        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose card to play");
        int cardToPlay = userInput.nextInt();
        playerOne.PlayCard(playerOne, cardToPlay);

//Test show hand and play card iterate 3 times
//        for (int i = 0; i < 3; i++) {
//            playerOne.showHand(playerOne);
//            Scanner userInput = new Scanner(System.in);
//            System.out.println("Choose card to play");
//            int cardToPlay = userInput.nextInt();
//            playerOne.PlayCard(playerOne, cardToPlay);}

//Display card in play and chose category to play
//        String categoryInPlay;
//        loop: do {
//            System.out.println("Choose category to play:" +
//                    "\n1 Hardness" +
//                    "\n2 Specific gravity" +
//                    "\n3 Cleavage" +
//                    "\n4 Crustal abundance" +
//                    "\n5 Economic value");
//            Scanner inputCategory = new Scanner(System.in);
//            int categorySelect = inputCategory.nextInt();
//            switch (categorySelect) {
//                case 1: categoryInPlay = "Hardness";
//                    break loop;
//                case 2: categoryInPlay = "Specific gravity";
//                    break loop;
//                case 3: categoryInPlay = "Cleavage";
//                    break loop;
//                case 4: categoryInPlay = "Crustal abundance";
//                    break loop;
//                case 5: categoryInPlay = "Economic value";
//                    break loop;
//                default: categoryInPlay = "";
//                    break;
//            }
//        } while (categoryInPlay.equals(""));
//
//        System.out.println("Category for this round is " + categoryInPlay);
    }
}
