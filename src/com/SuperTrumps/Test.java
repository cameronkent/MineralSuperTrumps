package com.SuperTrumps;

import java.util.Collections;

public class Test {
    public static void main(String[] args) throws Exception {

        System.out.println("creating deck..."); //DEBUGGING PROGRESS MARKER
        Deck cardDeck = new Deck();

//        System.out.println("printing cards..."); //DEBUGGING PROGRESS MARKER
//        cardDeck.print();
//
//        System.out.println("printing select card..."); //DEBUGGING PROGRESS MARKER
//        cardDeck.print(5);
//
//        System.out.println("printing select trump..."); //DEBUGGING PROGRESS MARKER
//        cardDeck.print(59);

        System.out.println("printing deck size..."); //DEBUGGING PROGRESS MARKER
        System.out.println(cardDeck.size());

        System.out.println("shuffling deck..."); //DEBUGGING PROGRESS MARKER
        Collections.shuffle(cardDeck.deckArray);

        System.out.println("printing random card..."); //DEBUGGING PROGRESS MARKER
        cardDeck.print(5);
    }
}
