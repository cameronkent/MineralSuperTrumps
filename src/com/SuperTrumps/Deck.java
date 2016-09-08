package com.SuperTrumps;

import com.dd.plist.*;
import com.dd.plist.PropertyListParser;
import java.io.File;
import java.util.ArrayList;

public class Deck {
    public ArrayList<Card> deckArray = new ArrayList();

    public Deck() throws Exception {

        try {
            int minerals = 0;
            int trumps = 54;

            File file = new File("MstCards_151021.plist");
            NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(file);
            NSArray cardsArray = (NSArray) rootDict.objectForKey("cards");


            while (minerals < 54) {

                NSDictionary mineralCard = (NSDictionary) cardsArray.objectAtIndex(minerals);

                NSString title = (NSString) mineralCard.objectForKey("title");
                NSString chemistry = (NSString) mineralCard.objectForKey("chemistry");
                NSString classification = (NSString) mineralCard.objectForKey("classification");
                NSString crystalSystem = (NSString) mineralCard.objectForKey("crystal_system");
                NSArray occurrence = (NSArray) mineralCard.objectForKey("occurrence");
                NSString hardness = (NSString) mineralCard.objectForKey("hardness");
                NSString specificGravity = (NSString) mineralCard.objectForKey("specific_gravity");
                NSString cleavage = (NSString) mineralCard.objectForKey("cleavage");
                NSString crustalAbundance = (NSString) mineralCard.objectForKey("crustal_abundance");
                NSString economicValue = (NSString) mineralCard.objectForKey("economic_value");

                deckArray.add(new Card(title, chemistry, classification, crystalSystem, occurrence, hardness, specificGravity, cleavage, crustalAbundance, economicValue));
                minerals =+ 1;
            }

            while (trumps < 60) {

                NSDictionary trumpCard = (NSDictionary) cardsArray.objectAtIndex(trumps);

                NSString title = (NSString) trumpCard.objectForKey("title");
                NSString subtitle = (NSString) trumpCard.objectForKey("subtitle");

                deckArray.add(new TrumpCard(title, subtitle));
                trumps =+ 1;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            return;
        }
    }

    void print(){
        for (Card i: deckArray) {
            System.out.println(i.toString());
        }
    }
}