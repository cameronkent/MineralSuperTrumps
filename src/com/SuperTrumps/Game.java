package com.SuperTrumps;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Random;

class Game {

    int numPlayers;
    UserPlayer userPlayer;
    Player[] players;
    ComPlayer[] comPlayer;
    Deck cardDeck;
    int roundCount;

    private int dealer;

    Game(int numPlayers) {
        this.numPlayers = numPlayers;
        comPlayer = new ComPlayer[numPlayers];
        players = new Player[numPlayers + 1];
    }

    public void setUserPlayer(String playerName) {
        userPlayer = new UserPlayer(playerName);
        //players[0] = userPlayer;
    }

    public void setComPlayers() {
        for (int i = 0; i < numPlayers; i++) {
            comPlayer[i] = new ComPlayer(i + 1);
            //players[i + 1] = comPlayer[i + 1];
            comPlayer[i].playerName = "Computer " + (Integer.toString(i + 1));
        }
    }

    public void showPlayers() {
        System.out.println("This games players are:");
        System.out.println(userPlayer.playerName);
        for (int i = 0; i < comPlayer.length; i++) {
            System.out.println(comPlayer[i].playerName);
        }
    }

    public void buildCardDeck() throws Exception {
        cardDeck = new Deck();
        Collections.shuffle(cardDeck.deckArray);
        System.out.println("The deck has been shuffled. \nThere are " + cardDeck.size() + " Mineral and SuperTrump cards.\n");
    }

    public void randomiseDealer() {
        Random random = new Random();
        dealer = random.nextInt(numPlayers) + 1;
        if (dealer == 1) {
            System.out.println(userPlayer.playerName + " is dealing this round\n");
        }else {
            System.out.println(comPlayer[dealer - 1].playerName + " is dealing this round\n");
        }
    }

    public void dealPlayerHands() {
        userPlayer.DealHand(userPlayer, cardDeck);
        for (int j = 0; j < comPlayer.length; j++) comPlayer[j].DealHand(comPlayer[j], cardDeck);
        System.out.println("The hands have been dealt. \nThere are " + cardDeck.size() + " cards remaining.\n");
    }

    public void startNewRound() { // TODO: 20/09/2016 refactor to methods using round class

        Card cardInPlay = null;
        int categoryNumber = 0;
        int valueInPlay;
        int valueToPlay;
        int playerTurn;
        String categoryAsString;
        String categoryValueAsString;
        //Array[] playerTurn = new Array[numPlayers];// TODO: 20/09/2016 build turn order

//Start Round
        roundCount = roundCount + 1;
        playerTurn = dealer - 1;
        switch (playerTurn) {
            case 0:
                userPlayer.showHand(userPlayer);
                cardInPlay = userPlayer.getCardToPlay(userPlayer);
                categoryNumber = userPlayer.getCategoryToPlay();
                playerTurn = numPlayers;
                break;
            case 1:
                cardInPlay = comPlayer[0].PlayCard(comPlayer[0], comPlayer[0].getRandCard(comPlayer[0]));
                categoryNumber = comPlayer[0].getCategoryFromComPlayer();
                playerTurn = 0;
                break;
            case 2:
                cardInPlay = comPlayer[1].PlayCard(comPlayer[1], comPlayer[1].getRandCard(comPlayer[1]));
                categoryNumber = comPlayer[1].getCategoryFromComPlayer();
                playerTurn = 1;
                break;
            case 3:
                cardInPlay = comPlayer[2].PlayCard(comPlayer[2], comPlayer[2].getRandCard(comPlayer[2]));
                categoryNumber = comPlayer[2].getCategoryFromComPlayer();
                playerTurn = 2;
                break;
            case 4:
                cardInPlay = comPlayer[3].PlayCard(comPlayer[3], comPlayer[3].getRandCard(comPlayer[3]));
                categoryNumber = comPlayer[3].getCategoryFromComPlayer();
                playerTurn = 3;
                break;
        }

        categoryAsString = getCategoryAsString(categoryNumber);
        categoryValueAsString = cardInPlay.getCategoryInPlay(categoryNumber);
        valueInPlay = Game.getValueToPlay(categoryNumber, categoryValueAsString);

        System.out.println("Category for this round is: " + categoryAsString.toUpperCase());
        System.out.println("Score to beat is: " + categoryValueAsString);

        switch (playerTurn) {
            case 0:
                if (!userPlayer.passedTurn) {
                    userPlayer.showHand(userPlayer);
                    cardInPlay = userPlayer.getCardToPlay(userPlayer);
                }
                playerTurn = numPlayers;
                break;
            case 1:
                playerTurn = 0;
                break;
            case 2:
                playerTurn = 1;
                break;
            case 3:
                playerTurn = 2;
                break;
            case 4:
                playerTurn = 3;
                break;
        }


//        if (!userPlayer.passedTurn) {
//            userPlayer.showHand(userPlayer);
//            cardInPlay = userPlayer.getCardToPlay(userPlayer);
//        }

////ComPlayers play or pass
//        for (int i = 0; i < comPlayer.length; i++) {
//            //check if 'passed' and then play card or pass round
//            while (!comPlayer[i].passedTurn) {
//                int comMove = comPlayer[i].playCardOrPass(categoryNumber, valueInPlay);
//                if (comMove == 0) {
//                    comPlayer[i].DrawCard(comPlayer[i], cardDeck);
//                    comPlayer[i].passedTurn = true;
//                } else {
//                    comPlayer[i].PlayCard(comPlayer[i], i+1);
//                }
//            }
//        }
//
    }


//____________________________________________________________________________________________________________________
    //Return a string of category for printing
    public String getCategoryAsString(int categorySelect ) {
        String categoryAsString;
        loop: do {
            switch (categorySelect) {
                case 1: categoryAsString = "Hardness";
                    break loop;
                case 2: categoryAsString = "Specific gravity";
                    break loop;
                case 3: categoryAsString = "Cleavage";
                    break loop;
                case 4: categoryAsString = "Crustal abundance";
                    break loop;
                case 5: categoryAsString = "Economic value";
                    break loop;
                default: categoryAsString = "";
                    break;
            }
        } while (categoryAsString.equals(""));
        return categoryAsString;
    }

    //find category to get values
    public static int getValueToPlay (int categorySelect, String categoryValueAsString) {
        int valueToPlay = 0;
        if (categorySelect == 1) {
            valueToPlay = getHardnessAsInt(categoryValueAsString);
        } else if (categorySelect == 2) {
            valueToPlay = getSpecificGravityAsInt(categoryValueAsString);
        } else if (categorySelect == 3) {
            valueToPlay = getCleavageAsInt(categoryValueAsString);
        } else if (categorySelect == 4) {
            valueToPlay = getCrustalAbundanceAsInt(categoryValueAsString);
        } else if (categorySelect == 5) {
            valueToPlay = getEconomicValueAsInt(categoryValueAsString);
        } return valueToPlay;
    }

    //Return Hardness as int for comparison
    public static int getHardnessAsInt(String hardness) {
        int hardnessAsInt = 0;
        switch (hardness){
            case "1" : return 1;
            case "1-1.5" : return 2;
            case "1-2" : return 3;
            case "1.5.2.5" : return 4;
            case "2" : return 5;
            case "2.5" : return 6;
            case "2-3" : return 7;
            case "2.5-3" : return 8;
            case "2.5-3.5" : return 9;
            case "3" : return 10;
            case "3-3.5" : return 11;
            case "3.5-3.6" : return 12;
            case "3.5-4" : return 13;
            case "3.5-4.5" : return 14;
            case "4" : return 15;
            case "4-4.5" : return 16;
            case "5" : return 17;
            case "5-5.5" : return 18;
            case "5.5" : return 19;
            case "5-6" : return 20;
            case "5.5-6" : return 21;
            case "5.5-6.5" : return 22;
            case "5.5-7" : return 23;
            case "6" : return 24;
            case "6-6.5" : return 25;
            case "6-7" : return 26;
            case "6.5-7" : return 27;
            case "6-7.5" : return 28;
            case "6.5-7.5" : return 29;
            case "7" : return 30;
            case "7.5" : return 31;
            case "7.5-8" : return 32;
            case "8" : return 33;
            case "9" : return 34;
            case "10" : return 35;
        } return hardnessAsInt;
    }

    //Return specific gravity as int for comparison
    public static int getSpecificGravityAsInt(String specificGravity) {
        int hardnessAsInt = 0;
        switch (specificGravity) {
            case "2.2" : return 1;
            case "2.3" : return 2;
            case "2.4" : return 3;
            case "2.5-2.6" : return 4;
            case "2.6" : return 5;
            case "2.65" : return 6;
            case "2.6-2.7" : return 7;
            case "2.6-2.8" : return 8;
            case "2.6-3.3" : return 9;
            case "2.6-2.9" : return 10;
            case "2.7" : return 11;
            case "2.7-3.3" : return 12;
            case "2.8-2.9" : return 13;
            case "2.9" : return 14;
            case "3.0" : return 15;
            case "3.0-3.2" : return 16;
            case "3.15" : return 17;
            case "3.0-3.5" : return 18;
            case "3.1-3.2" : return 19;
            case "3.2" : return 20;
            case "3.25" : return 21;
            case "3.2-4.4" : return 22;
            case "3.2-3.5" : return 23;
            case "3.2-3.6" : return 24;
            case "3.2-3.9" : return 25;
            case "3.4-3.6" : return 26;
            case "3.5" : return 27;
            case "3.5-3.6" : return 28;
            case "3.5-3.7" : return 29;
            case "3.5-4.3" : return 30;
            case "3.7-3.8" : return 31;
            case "3.9-4.1" : return 32;
            case "4.0" : return 33;
            case "4.1-4.3" : return 34;
            case "4.3" : return 35;
            case "4.5" : return 36;
            case "4.5-5.1" : return 37;
            case "4.6" : return 38;
            case "4.6-4.7" : return 39;
            case "4.7" : return 40;
            case "4.7-4.8" : return 41;
            case "5.0" : return 42;
            case "5.0-5.3" : return 43;
            case "5.2" : return 44;
            case "5.3" : return 45;
            case "6.9-7.1" : return 46;
            case "7.5-7.6" : return 47;
            case "19.3" : return 48;

        }return hardnessAsInt;
    }

    //Return cleavage as int for comparison
    public static int getCleavageAsInt(String cleavage) {
        int cleavageAsInt = 0;
        switch (cleavage){
            case "none": return 1;
            case "poor/none": return 2;
            case "1 poor": return 3;
            case "2 poor": return 4;
            case "1 good": return 5;
            case "1 good, 1 poor": return 6;
            case "2 good": return 7;
            case "3 good": return 8;
            case "1 perfect": return 9;
            case "1 perfect, 1 good": return 10;
            case "1 perfect, 2 good": return 11;
            case "2 perfect, 1 good": return 12;
            case "3 perfect": return 13;
            case "4 perfect": return 14;
            case "6 perfect": return 15;
        }return cleavageAsInt;
    }

    //Return crustal abundance as int for comparison
    public static int getCrustalAbundanceAsInt(String crustalAbundance) {
        int crustalAbundanceAsInt = 0;
        switch (crustalAbundance){
            case "ultratrace": return 1;
            case "trace": return 2;
            case "low": return 3;
            case "moderate": return 4;
            case "high": return 5;
            case "very high": return 6;
        }return crustalAbundanceAsInt;
    }

    //Return economic value as int for comparison
    public static int getEconomicValueAsInt(String economicValue) {
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

}
