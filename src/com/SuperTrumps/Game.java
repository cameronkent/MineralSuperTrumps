package com.SuperTrumps;

import java.util.Collections;
import java.util.Random;

class Game {

    private int numPlayers;
    int roundCount;
    private int dealer;
    private int playerTurn;
    private int playersInRound;
    private int categoryNumber = 0;
    private int valueInPlay;
    private String categoryAsString;
    private String categoryValueAsString;
    Deck cardDeck;
    private Card cardInPlay = null;
    private Player[] players;
    private UserPlayer userPlayer;
    private ComPlayer[] comPlayer;
    Player gameWinner;
    private boolean trumpPlayed;


    Game(int numPlayers) {
        this.numPlayers = numPlayers;
        comPlayer = new ComPlayer[numPlayers];
        players = new Player[numPlayers + 1];
    }

    void setUserPlayer(String playerName) {
        userPlayer = new UserPlayer(playerName);
        //players[0] = userPlayer;
    }

    void setComPlayers() {
        for (int i = 0; i < numPlayers; i++) {
            comPlayer[i] = new ComPlayer(i + 1);
            //players[i + 1] = comPlayer[i + 1];
            comPlayer[i].playerName = "Computer " + (Integer.toString(i + 1));
        }
    }

    void showPlayers() {
        System.out.println("This games players are:");
        System.out.println(userPlayer.playerName);
        for (int i = 0; i < comPlayer.length; i++) {
            System.out.println(comPlayer[i].playerName);
        }
    }

    void buildCardDeck() throws Exception {
        cardDeck = new Deck();
        Collections.shuffle(cardDeck.deckArray);
        System.out.println("The deck has been shuffled. \nThere are " + cardDeck.size() + " Mineral and SuperTrump cards.\n");
    }

    void randomiseDealer() {
        Random random = new Random();
        dealer = random.nextInt(numPlayers) + 1;
        if (dealer == 1) {
            System.out.println(userPlayer.playerName + " is dealing this round\n");
        }else {
            System.out.println(comPlayer[dealer - 1].playerName + " is dealing this round\n");
        }
    }

    void dealPlayerHands() {
        userPlayer.DealHand(userPlayer, cardDeck);
        for (int j = 0; j < comPlayer.length; j++) comPlayer[j].DealHand(comPlayer[j], cardDeck);
        System.out.println("The hands have been dealt. \nThere are " + cardDeck.size() + " cards remaining.\n");
    }

    void playGameRound() {
        playersInRound = numPlayers + 1;
        roundCount = roundCount + 1;

        if (!trumpPlayed) { // TODO: 28/09/16 implement trump set category
            startGameRound();
        }

        trumpPlayed = false;

        do {
            playGameRoundTurns();
        } while (playersInRound > 1);

    }


//____________________________________________________________________________________________________________________

    private void checkWinCondition(Player player) {
        if (player.Hand.size() == 0) {
            gameWinner = player;
            playersInRound = 0;
            Main.gameOver = true;
        } else {
            Main.gameOver = false;
        }
    }

    void resetPassedPlayers(){
        this.userPlayer.passedTurn = false;
        for (int i = 0; i < numPlayers; i++) {
            this.comPlayer[i].passedTurn =false;
        }
    }

    private void startGameRound() {
        if (dealer == 1) { playerTurn = numPlayers; }
        else {playerTurn = dealer - 1; }
        switch (playerTurn) {
            case 0:
                startRoundUserPlayer();
                playerTurn = numPlayers;
                break;
            case 1:
                startRoundComPlayer(comPlayer[0]);
                playerTurn = 0;
                break;
            case 2:
                startRoundComPlayer(comPlayer[1]);
                playerTurn = 1;
                break;
            case 3:
                startRoundComPlayer(comPlayer[2]);
                playerTurn = 2;
                break;
            case 4:
                startRoundComPlayer(comPlayer[3]);
                playerTurn = 3;
                break;
        }
        categoryAsString = getCategoryAsString(categoryNumber);
        setCurrentValues();
        displayCurrentValue();
    }

    private void playGameRoundTurns() {
        switch (playerTurn) {
            case 0:
                playTurnUserPlayer();
                playerTurn = numPlayers;
                break;
            case 1:
                playTurnComPlayer(comPlayer[0]);
                playerTurn = 0;
                break;
            case 2:
                playTurnComPlayer(comPlayer[1]);
                playerTurn = 1;
                break;
            case 3:
                playTurnComPlayer(comPlayer[2]);
                playerTurn = 2;
                break;
            case 4:
                playTurnComPlayer(comPlayer[3]);
                playerTurn = 3;
                break;
        }
        setCurrentValues();
        displayCurrentValue();
    }

    private void setCurrentValues() {
        categoryValueAsString = cardInPlay.getCategoryInPlay(categoryNumber);
        valueInPlay = getValueToPlay(categoryNumber, cardInPlay.getCategoryInPlay(categoryNumber));
    }

    private void displayCurrentValue() {
        System.out.println("\nCategory for this round is: " + categoryAsString.toUpperCase());
        System.out.println("Score to beat is: " + categoryValueAsString.toUpperCase() + "\n");
    }

    private void startRoundUserPlayer() {
        userPlayer.showHand(userPlayer);
        int cardToPlay = userPlayer.getCardToPlay();
        cardInPlay = userPlayer.PlayCard(userPlayer, cardToPlay);
        categoryNumber = userPlayer.getCategoryToPlay();
        checkWinCondition(userPlayer);
    }

    private void startRoundComPlayer(ComPlayer comPlayer) {
        Card cardToPlay;
        loop: for (int i = 0; i < comPlayer.Hand.size(); i++) {
            cardToPlay = comPlayer.Hand.get(i);
            if (!cardToPlay.isTrump) {
                cardInPlay = comPlayer.PlayCard(comPlayer, comPlayer.getRandCard(comPlayer));
                categoryNumber = comPlayer.getCategoryFromComPlayer();
                checkWinCondition(comPlayer);
                break loop;
            }
        }
//        cardInPlay = comPlayer.PlayCard(comPlayer, comPlayer.getRandCard(comPlayer));
//        categoryNumber = comPlayer.getCategoryFromComPlayer();
//        checkWinCondition(comPlayer);
    }

    //Gets the user to choose to play a card or pass turn
    private void playTurnUserPlayer(){
        if (!userPlayer.passedTurn) {
            userPlayer.showHand(userPlayer);
            int userMove = userPlayer.playOrPass();
            if (userMove == 1) {
                int cardToPlay = userPlayer.getCardToPlay();
                int valueToPlay = getValueToPlay(categoryNumber, userPlayer.Hand.get(cardToPlay-1).getCategoryInPlay(categoryNumber));
                if (valueToPlay > valueInPlay) {
                    cardInPlay = userPlayer.PlayCard(userPlayer, cardToPlay);
                    checkWinCondition(userPlayer);
                } else { passPlayerTurn(userPlayer); }
            } else {
                passPlayerTurn(userPlayer);
            }
        }
    }

    //ComPlayer turn; either plays a higher card or passes
    private void playTurnComPlayer(ComPlayer comPlayer) {
        if (!comPlayer.passedTurn) {
            int comMove = comPlayer.playCardOrPass(categoryNumber, valueInPlay);
            if (comMove == 0) {
                passPlayerTurn(comPlayer);
            } else if (comPlayer.Hand.get(comMove).isTrump){
                activateTrumpCard(comPlayer, comMove);
            }
            else {
                cardInPlay = comPlayer.PlayCard(comPlayer, comMove);
                checkWinCondition(comPlayer);
            }
        }
    }

    private void activateTrumpCard(Player player, int trump) {
        cardInPlay = player.PlayTrump(player, trump);
        categoryValueAsString = cardInPlay.getCategoryInPlay(categoryNumber);
        valueInPlay = 0;
        playersInRound = 0;
        trumpPlayed = true;

        switch (cardInPlay.title) {
            case "The Geologist":
                if (player == userPlayer) {
                    categoryNumber = userPlayer.getCategoryToPlay();
                }else {
                    categoryNumber = ComPlayer.getCategoryFromComPlayer();
                }
                break;
            case "The Gemmologist":
                categoryNumber = 1;
                break;
            case "The Mineralogist":
                categoryNumber = 3;
                break;
            case "The Miner":
                categoryNumber = 5;
                break;
            case "The Petrologist":
                categoryNumber = 4;
                break;
            case "The Geophysicist":
                categoryNumber = 2;//todo: or throw magnetite
                break;
        }
    }

    //Standard pass method for all players
    private void passPlayerTurn(Player player) {
        player.DrawCard(player, cardDeck);
        player.passedTurn = true;
        playersInRound = playersInRound - 1;
        System.out.println(playersInRound + " players left in round.");
    }

    //Return a string of category for printing
    private String getCategoryAsString(int categoryNumber ) {
        String categoryAsString;
        loop: do {
            switch (categoryNumber) {
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
    public static int getValueToPlay(int categoryNumber, String categoryValueAsString) {
        int valueToPlay = 0;
        switch (categoryNumber) {
            case 1:
                valueToPlay = getHardnessAsInt(categoryValueAsString);
                return valueToPlay;
            case 2:
                valueToPlay = getSpecificGravityAsInt(categoryValueAsString);
                return valueToPlay;
            case 3:
                valueToPlay = getCleavageAsInt(categoryValueAsString);
                return valueToPlay;
            case 4:
                valueToPlay = getCrustalAbundanceAsInt(categoryValueAsString);
                return valueToPlay;
            case 5:
                valueToPlay = getEconomicValueAsInt(categoryValueAsString);
                return valueToPlay;
        } return valueToPlay;
    }

    //Return Hardness as int for comparison
    private static int getHardnessAsInt(String hardness) {
        int hardnessAsInt = 0;
        switch (hardness){
            case "1" :
                hardnessAsInt = 1;
                return hardnessAsInt;
            case "1-1.5" :
                hardnessAsInt = 2;
                return hardnessAsInt;
            case "1-2" :
                hardnessAsInt = 3;
                return hardnessAsInt;
            case "1.5.2.5" :
                hardnessAsInt = 4;
                return hardnessAsInt;
            case "2" :
                hardnessAsInt = 5;
                return hardnessAsInt;
            case "2.5" :
                hardnessAsInt = 6;
                return hardnessAsInt;
            case "2-3" :
                hardnessAsInt = 7;
                return hardnessAsInt;
            case "2.5-3" :
                hardnessAsInt = 8;
                return hardnessAsInt;
            case "2.5-3.5" :
                hardnessAsInt = 9;
                return hardnessAsInt;
            case "3" :
                hardnessAsInt = 10;
                return hardnessAsInt;
            case "3-3.5" :
                hardnessAsInt = 11;
                return hardnessAsInt;
            case "3.5-3.6" :
                hardnessAsInt = 12;
                return hardnessAsInt;
            case "3.5-4" :
                hardnessAsInt = 13;
                return hardnessAsInt;
            case "3.5-4.5" :
                hardnessAsInt = 14;
                return hardnessAsInt;
            case "4" :
                hardnessAsInt = 15;
                return hardnessAsInt;
            case "4-4.5" :
                hardnessAsInt = 16;
                return hardnessAsInt;
            case "5" :
                hardnessAsInt = 17;
                return hardnessAsInt;
            case "5-5.5" :
                hardnessAsInt = 18;
                return hardnessAsInt;
            case "5.5" :
                hardnessAsInt = 19;
                return hardnessAsInt;
            case "5-6" :
                hardnessAsInt = 20;
                return hardnessAsInt;
            case "5.5-6" :
                hardnessAsInt = 21;
                return hardnessAsInt;
            case "5.5-6.5" :
                hardnessAsInt = 22;
                return hardnessAsInt;
            case "5.5-7" :
                hardnessAsInt = 23;
                return hardnessAsInt;
            case "6" :
                hardnessAsInt = 24;
                return hardnessAsInt;
            case "6-6.5" :
                hardnessAsInt = 25;
                return hardnessAsInt;
            case "6-7" :
                hardnessAsInt = 26;
                return hardnessAsInt;
            case "6.5-7" :
                hardnessAsInt = 27;
                return hardnessAsInt;
            case "6-7.5" :
                hardnessAsInt = 28;
                return hardnessAsInt;
            case "6.5-7.5" :
                hardnessAsInt = 29;
                return hardnessAsInt;
            case "7" :
                hardnessAsInt = 30;
                return hardnessAsInt;
            case "7.5" :
                hardnessAsInt = 31;
                return hardnessAsInt;
            case "7.5-8" :
                hardnessAsInt = 32;
                return hardnessAsInt;
            case "8" :
                hardnessAsInt = 33;
                return hardnessAsInt;
            case "9" :
                hardnessAsInt = 34;
                return hardnessAsInt;
            case "10" :
                hardnessAsInt = 35;
                return hardnessAsInt;
        } return hardnessAsInt;
    }

    //Return specific gravity as int for comparison
    private static int getSpecificGravityAsInt(String specificGravity) {
        int specificGravityAsInt = 0;
        switch (specificGravity) {
            case "2.2" :
                specificGravityAsInt = 1;
                return specificGravityAsInt;
            case "2.3" :
                specificGravityAsInt = 2;
                return specificGravityAsInt;
            case "2.4" :
                specificGravityAsInt = 3;
                return specificGravityAsInt;
            case "2.5-2.6" :
                specificGravityAsInt = 4;
                return specificGravityAsInt;
            case "2.6" :
                specificGravityAsInt = 5;
                return specificGravityAsInt;
            case "2.65" :
                specificGravityAsInt = 6;
                return specificGravityAsInt;
            case "2.6-2.7" :
                specificGravityAsInt = 7;
                return specificGravityAsInt;
            case "2.6-2.8" :
                specificGravityAsInt = 8;
                return specificGravityAsInt;
            case "2.6-3.3" :
                specificGravityAsInt = 9;
                return specificGravityAsInt;
            case "2.6-2.9" :
                specificGravityAsInt = 10;
                return specificGravityAsInt;
            case "2.7" :
                specificGravityAsInt = 11;
                return specificGravityAsInt;
            case "2.7-3.3" :
                specificGravityAsInt = 12;
                return specificGravityAsInt;
            case "2.8-2.9" :
                specificGravityAsInt = 13;
                return specificGravityAsInt;
            case "2.9" :
                specificGravityAsInt = 14;
                return specificGravityAsInt;
            case "3.0" :
                specificGravityAsInt = 15;
                return specificGravityAsInt;
            case "3.0-3.2" :
                specificGravityAsInt = 16;
                return specificGravityAsInt;
            case "3.15" :
                specificGravityAsInt = 17;
                return specificGravityAsInt;
            case "3.0-3.5" :
                specificGravityAsInt = 18;
                return specificGravityAsInt;
            case "3.1-3.2" :
                specificGravityAsInt = 19;
                return specificGravityAsInt;
            case "3.2" :
                specificGravityAsInt = 20;
                return specificGravityAsInt;
            case "3.25" :
                specificGravityAsInt = 21;
                return specificGravityAsInt;
            case "3.2-4.4" :
                specificGravityAsInt = 22;
                return specificGravityAsInt;
            case "3.2-3.5" :
                specificGravityAsInt = 23;
                return specificGravityAsInt;
            case "3.2-3.6" :
                specificGravityAsInt = 24;
                return specificGravityAsInt;
            case "3.2-3.9" :
                specificGravityAsInt = 25;
                return specificGravityAsInt;
            case "3.4-3.6" :
                specificGravityAsInt = 26;
                return specificGravityAsInt;
            case "3.5" :
                specificGravityAsInt = 27;
                return specificGravityAsInt;
            case "3.5-3.6" :
                specificGravityAsInt = 28;
                return specificGravityAsInt;
            case "3.5-3.7" :
                specificGravityAsInt = 29;
                return specificGravityAsInt;
            case "3.5-4.3" :
                specificGravityAsInt = 30;
                return specificGravityAsInt;
            case "3.7-3.8" :
                specificGravityAsInt = 31;
                return specificGravityAsInt;
            case "3.9-4.1" :
                specificGravityAsInt = 32;
                return specificGravityAsInt;
            case "4.0" :
                specificGravityAsInt = 33;
                return specificGravityAsInt;
            case "4.1-4.3" :
                specificGravityAsInt = 34;
                return specificGravityAsInt;
            case "4.3" :
                specificGravityAsInt = 35;
                return specificGravityAsInt;
            case "4.5" :
                specificGravityAsInt = 36;
                return specificGravityAsInt;
            case "4.5-5.1" :
                specificGravityAsInt = 37;
                return specificGravityAsInt;
            case "4.6" :
                specificGravityAsInt = 38;
                return specificGravityAsInt;
            case "4.6-4.7" :
                specificGravityAsInt = 39;
                return specificGravityAsInt;
            case "4.7" :
                specificGravityAsInt = 40;
                return specificGravityAsInt;
            case "4.7-4.8" :
                specificGravityAsInt = 41;
                return specificGravityAsInt;
            case "5.0" :
                specificGravityAsInt = 42;
                return specificGravityAsInt;
            case "5.0-5.3" :
                specificGravityAsInt = 43;
                return specificGravityAsInt;
            case "5.2" :
                specificGravityAsInt = 44;
                return specificGravityAsInt;
            case "5.3" :
                specificGravityAsInt = 45;
                return specificGravityAsInt;
            case "6.9-7.1" :
                specificGravityAsInt = 46;
                return specificGravityAsInt;
            case "7.5-7.6" :
                specificGravityAsInt = 47;
                return specificGravityAsInt;
            case "19.3" :
                specificGravityAsInt = 48;
                return specificGravityAsInt;
        }return specificGravityAsInt;
    }

    //Return cleavage as int for comparison
    private static int getCleavageAsInt(String cleavage) {
        int cleavageAsInt = 0;
        switch (cleavage){
            case "none":
                cleavageAsInt = 1;
                return cleavageAsInt;
            case "poor/none":
                cleavageAsInt = 2;
                return cleavageAsInt;
            case "1 poor":
                cleavageAsInt = 3;
                return cleavageAsInt;
            case "2 poor":
                cleavageAsInt = 4;
                return cleavageAsInt;
            case "1 good":
                cleavageAsInt = 5;
                return cleavageAsInt;
            case "1 good, 1 poor":
                cleavageAsInt = 6;
                return cleavageAsInt;
            case "2 good":
                cleavageAsInt = 7;
                return cleavageAsInt;
            case "3 good":
                cleavageAsInt = 8;
                return cleavageAsInt;
            case "1 perfect":
                cleavageAsInt = 9;
                return cleavageAsInt;
            case "1 perfect, 1 good":
                cleavageAsInt = 10;
                return cleavageAsInt;
            case "1 perfect, 2 good":
                cleavageAsInt = 11;
                return cleavageAsInt;
            case "2 perfect, 1 good":
                cleavageAsInt = 12;
                return cleavageAsInt;
            case "3 perfect":
                cleavageAsInt = 13;
                return cleavageAsInt;
            case "4 perfect":
                cleavageAsInt = 14;
                return cleavageAsInt;
            case "6 perfect":
                cleavageAsInt = 15;
                return cleavageAsInt;
        }return cleavageAsInt;
    }

    //Return crustal abundance as int for comparison
    private static int getCrustalAbundanceAsInt(String crustalAbundance) {
        int crustalAbundanceAsInt = 0;
        switch (crustalAbundance){
            case "ultratrace":
                crustalAbundanceAsInt = 1;
                return crustalAbundanceAsInt;
            case "trace":
                crustalAbundanceAsInt = 2;
                return crustalAbundanceAsInt;
            case "low":
                crustalAbundanceAsInt = 3;
                return crustalAbundanceAsInt;
            case "moderate":
                crustalAbundanceAsInt = 4;
                return crustalAbundanceAsInt;
            case "high":
                crustalAbundanceAsInt = 5;
                return crustalAbundanceAsInt;
            case "very high":
                crustalAbundanceAsInt = 6;
                return crustalAbundanceAsInt;
        }return crustalAbundanceAsInt;
    }

    //Return economic value as int for comparison
    private static int getEconomicValueAsInt(String economicValue) {
        int economicValueAsInt = 0;
        switch (economicValue){
            case "trivial":
                economicValueAsInt = 1;
                return economicValueAsInt;
            case "low":
                economicValueAsInt = 2;
                return economicValueAsInt;
            case "moderate":
                economicValueAsInt = 3;
                return economicValueAsInt;
            case "high":
                economicValueAsInt = 4;
                return economicValueAsInt;
            case "very high":
                economicValueAsInt = 5;
                return economicValueAsInt;
            case "I'm rich":
                economicValueAsInt = 6;
                return economicValueAsInt;
        }return economicValueAsInt;
    }

}
