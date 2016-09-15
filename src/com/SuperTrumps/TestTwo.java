package com.SuperTrumps;

import com.dd.plist.NSString;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TestTwo {

    public static void main(String[] args) throws Exception {

        Game gameOne = new Game();

        //Define variables used in running
        String categoryAsString;
        int categorySelect;
        String categoryValue;

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


        //Display card in play and choose category to play
        System.out.println("Choose category to play:" + "\n1 Hardness" + "\n2 Specific gravity" + "\n3 Cleavage" + "\n4 Crustal abundance" + "\n5 Economic value");
        Scanner inputCategory = new Scanner(System.in);
        categorySelect = inputCategory.nextInt();
        categoryAsString = gameOne.getCategoryAsString(categorySelect);
        categoryValue = "high";

        int valueToPlay = getEconomicValueAsInt(categoryValue);
        System.out.println("Category for this round is " + categoryAsString);




    }
    //Return economic value as int for comparison
    public int getEconomicValueAsInt(String economicValue) {
        int economicValueAsInt = 0;
        switch (economicValue){
            case "trivial": return 1;
            case "low": return 2;
            case "moderate": return 3;
            case "high": return 4;
            case "very high": return 5;
            case "I'm rich": return 6;
        }return economicValueAsInt;
    }

    //Return crustal abundance as int for comparison
    public int getCrustalAbundanceAsInt(String economicValue) {
        int economicValueAsInt = 0;
        switch (economicValue){
            case "ultratrace": return 1;
            case "trace": return 2;
            case "low": return 3;
            case "moderate": return 4;
            case "high": return 5;
            case "very high": return 6;
        }return economicValueAsInt;
    }

    //Return cleavage as int for comparison
    public int getEconomicValueAsInt(String economicValue) {
        int economicValueAsInt = 0;
        switch (economicValue){
            case "none": return 1;
            case "poor/none": return 2;
            case "1 poor": return 3;
            case "2 poor": return 4;
            case "1 good": return 5;
            case "I1 good, 1 poor": return 6;
            case "2 good": return 7;
            case "3 good": return 8;
            case "1 perfect": return 9;
            case "1 perfect, 1 good": return 10;
            case "1 perfect, 2 good": return 11;
            case "2 perfect, 1 good": return 12;
            case "3 perfect": return 13;
            case "4 perfect": return 14;
            case "6 perfect": return 15;
        }return economicValueAsInt;
    }

}
