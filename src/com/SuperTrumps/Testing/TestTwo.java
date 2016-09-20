package com.SuperTrumps.Testing;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TestTwo {

    public static void main(String[] args) throws Exception {

        int dealer;
        int numPlayers = 3;

        Random random = new Random();
        dealer = random.nextInt(numPlayers) + 1;
        if (dealer == 1) {
            System.out.println( "player is dealing this round");
        }else {
            System.out.println(dealer + " is dealing this round");
        }
//        Game gameOne = new Game();
//
////Define variables used in running
//        String categoryAsString;
//        int categorySelect;
//        String categoryValueAsString;
//        int valueToPlay;
//
////Build and shuffle deck
//        System.out.println("creating deck..."); Deck cardDeck = new Deck();
//        System.out.println("shuffling deck..."); Collections.shuffle(cardDeck.deckArray);
//
////Instantiate user, deal and display hand
//        UserPlayer playerOne = new UserPlayer();
//        playerOne.DealHand(playerOne, cardDeck);
//        playerOne.showHand(playerOne);
//
////Take input to play card from users hand
//        Scanner inputCardToPlay = new Scanner(System.in);
//        System.out.println("Choose card to play");
//        Card cardInPlay = playerOne.PlayCard(playerOne, inputCardToPlay.nextInt());
//
//
////Display card in play and choose category to play
//        System.out.println("Choose category to play:" + "\n1 Hardness" + "\n2 Specific gravity" + "\n3 Cleavage" + "\n4 Crustal abundance" + "\n5 Economic value");
//        Scanner inputCategory = new Scanner(System.in);
//        categorySelect = inputCategory.nextInt();
//        categoryAsString = gameOne.getCategoryAsString(categorySelect);
//        categoryValueAsString = cardInPlay.getCategoryInPlay(categorySelect);
//        System.out.println("Category for this round is " + categoryAsString);
//        System.out.println("Score to beat is: " + categoryValueAsString);


        //valueToPlay = getValueToPlay(categorySelect, categoryValueAsString);

        //System.out.println(valueToPlay);// check if value is returned



    }

//    //find category to get values
//    public static int getValueToPlay (int categorySelect, String categoryValueAsString) {
//        int valueToPlay = 0;
//        if (categorySelect == 1) {
//            valueToPlay = getHardnessAsInt(categoryValueAsString);
//        } else if (categorySelect == 2) {
//            valueToPlay = getSpecificGravityAsInt(categoryValueAsString);
//        } else if (categorySelect == 3) {
//            valueToPlay = getCleavageAsInt(categoryValueAsString);
//        } else if (categorySelect == 4) {
//            valueToPlay = getCrustalAbundanceAsInt(categoryValueAsString);
//        } else if (categorySelect == 5) {
//            valueToPlay = getEconomicValueAsInt(categoryValueAsString);
//        } return valueToPlay;
//    }
//
//    //Return Hardness as int for comparison
//    public static int getHardnessAsInt(String hardness) {
//        int hardnessAsInt = 0;
//        switch (hardness){
//            case "1" : return 1;
//            case "1-1.5" : return 2;
//            case "1-2" : return 3;
//            case "1.5.2.5" : return 4;
//            case "2" : return 5;
//            case "2.5" : return 6;
//            case "2-3" : return 7;
//            case "2.5-3" : return 8;
//            case "2.5-3.5" : return 9;
//            case "3" : return 10;
//            case "3-3.5" : return 11;
//            case "3.5-3.6" : return 12;
//            case "3.5-4" : return 13;
//            case "3.5-4.5" : return 14;
//            case "4" : return 15;
//            case "4-4.5" : return 16;
//            case "5" : return 17;
//            case "5-5.5" : return 18;
//            case "5.5" : return 19;
//            case "5-6" : return 20;
//            case "5.5-6" : return 21;
//            case "5.5-6.5" : return 22;
//            case "5.5-7" : return 23;
//            case "6" : return 24;
//            case "6-6.5" : return 25;
//            case "6-7" : return 26;
//            case "6.5-7" : return 27;
//            case "6-7.5" : return 28;
//            case "6.5-7.5" : return 29;
//            case "7" : return 30;
//            case "7.5" : return 31;
//            case "7.5-8" : return 32;
//            case "8" : return 33;
//            case "9" : return 34;
//            case "10" : return 35;
//        } return hardnessAsInt;
//    }
//
//    //Return specific gravity as int for comparison
//    public static int getSpecificGravityAsInt(String specificGravity) {
//        int hardnessAsInt = 0;
//        switch (specificGravity) {
//            case "2.2" : return 1;
//            case "2.3" : return 2;
//            case "2.4" : return 3;
//            case "2.5-2.6" : return 4;
//            case "2.6" : return 5;
//            case "2.65" : return 6;
//            case "2.6-2.7" : return 7;
//            case "2.6-2.8" : return 8;
//            case "2.6-3.3" : return 9;
//            case "2.6-2.9" : return 10;
//            case "2.7" : return 11;
//            case "2.7-3.3" : return 12;
//            case "2.8-2.9" : return 13;
//            case "2.9" : return 14;
//            case "3.0" : return 15;
//            case "3.0-3.2" : return 16;
//            case "3.15" : return 17;
//            case "3.0-3.5" : return 18;
//            case "3.1-3.2" : return 19;
//            case "3.2" : return 20;
//            case "3.25" : return 21;
//            case "3.2-4.4" : return 22;
//            case "3.2-3.5" : return 23;
//            case "3.2-3.6" : return 24;
//            case "3.2-3.9" : return 25;
//            case "3.4-3.6" : return 26;
//            case "3.5" : return 27;
//            case "3.5-3.6" : return 28;
//            case "3.5-3.7" : return 29;
//            case "3.5-4.3" : return 30;
//            case "3.7-3.8" : return 31;
//            case "3.9-4.1" : return 32;
//            case "4.0" : return 33;
//            case "4.1-4.3" : return 34;
//            case "4.3" : return 35;
//            case "4.5" : return 36;
//            case "4.5-5.1" : return 37;
//            case "4.6" : return 38;
//            case "4.6-4.7" : return 39;
//            case "4.7" : return 40;
//            case "4.7-4.8" : return 41;
//            case "5.0" : return 42;
//            case "5.0-5.3" : return 43;
//            case "5.2" : return 44;
//            case "5.3" : return 45;
//            case "6.9-7.1" : return 46;
//            case "7.5-7.6" : return 47;
//            case "19.3" : return 48;
//
//        }return hardnessAsInt;
//    }
//
//    //Return cleavage as int for comparison
//    public static int getCleavageAsInt(String cleavage) {
//        int cleavageAsInt = 0;
//        switch (cleavage){
//            case "none": return 1;
//            case "poor/none": return 2;
//            case "1 poor": return 3;
//            case "2 poor": return 4;
//            case "1 good": return 5;
//            case "1 good, 1 poor": return 6;
//            case "2 good": return 7;
//            case "3 good": return 8;
//            case "1 perfect": return 9;
//            case "1 perfect, 1 good": return 10;
//            case "1 perfect, 2 good": return 11;
//            case "2 perfect, 1 good": return 12;
//            case "3 perfect": return 13;
//            case "4 perfect": return 14;
//            case "6 perfect": return 15;
//        }return cleavageAsInt;
//    }
//
//    //Return crustal abundance as int for comparison
//    public static int getCrustalAbundanceAsInt(String crustalAbundance) {
//        int crustalAbundanceAsInt = 0;
//        switch (crustalAbundance){
//            case "ultratrace": return 1;
//            case "trace": return 2;
//            case "low": return 3;
//            case "moderate": return 4;
//            case "high": return 5;
//            case "very high": return 6;
//        }return crustalAbundanceAsInt;
//    }
//
//    //Return economic value as int for comparison
//    public static int getEconomicValueAsInt(String economicValue) {
//        int economicValueAsInt = 0;
//        switch (economicValue){
//            case "trivial": return 1;
//            case "low": return 2;
//            case "moderate": return 3;
//            case "high": return 4;
//            case "very high": return 5;
//            case "I'm rich": return 6;
//        }return economicValueAsInt;
//    }
//
}
