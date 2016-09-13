package com.SuperTrumps;

import com.dd.plist.NSString;

import java.util.Collections;
import java.util.Scanner;

public class TestTwo {

    public static void main(String[] args) throws Exception {

        //Define variables used in running
        String categoryAsString;
        int categorySelect;
        NSString categoryInPlay;

        //Build and shuffle deck
        System.out.println("creating deck..."); Deck cardDeck = new Deck();
        System.out.println("shuffling deck..."); Collections.shuffle(cardDeck.deckArray);

        //Instantiate user, deal and display hand
        UserPlayer playerOne = new UserPlayer();
        playerOne.DealHand(playerOne, cardDeck);
        playerOne.showHand(playerOne);

        //Take input to play card from users hand
        Scanner inputCardToPlay = new Scanner(System.in);
        System.out.println("Choose card to play");
        playerOne.PlayCard(playerOne, inputCardToPlay.nextInt());


        //Display card in play and chose category to play
        System.out.println("Choose category to play:" + "\n1 Hardness" + "\n2 Specific gravity" + "\n3 Cleavage" + "\n4 Crustal abundance" + "\n5 Economic value");
        Scanner inputCategory = new Scanner(System.in);
        categorySelect = inputCategory.nextInt();
        categoryAsString = playerOne.getCategoryAsString(categorySelect);

        System.out.println("Category for this round is " + categoryAsString);

    }
}
