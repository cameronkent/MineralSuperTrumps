package com.SuperTrumps;

import com.dd.plist.NSArray;
import com.dd.plist.NSString;

//                    fileName
//                    imageName
//                    card_type
public class Card {

    NSString title, chemistry, classification, crystalSystem, hardness, specificGravity, cleavage, crustalAbundance, economicValue;
    NSArray occurrence;

    public Card() {}

    public Card(NSString title, NSString chemistry, NSString classification, NSString crystalSystem, NSArray occurrence, NSString hardness, NSString specificGravity, NSString cleavage, NSString crustalAbundance, NSString economicValue) {
        this.title = title;
        this.chemistry = chemistry;
        this.classification = classification;
        this.crystalSystem = crystalSystem;
        this.occurrence = occurrence;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
        this.cleavage =cleavage;
        this.crustalAbundance = crustalAbundance;
        this.economicValue = economicValue;

    }

    @Override
    public String toString() {
        return ("--------------------" +
                "\n Element: " + this.title +
                "\n Chemistry: " + this.chemistry +
                "\n Classification: " + this.classification +
                "\n Crystal system: " + this.crystalSystem +
                "\n Occurrence: " + this.occurrence +
                "\n Hardness: " + this.hardness +
                "\n Specific Gravity: " + this.specificGravity +
                "\n Cleavage: " + this.cleavage +
                "\n Crustal abundance: " + this.crustalAbundance +
                "\n Economic value: " + this.economicValue +
                "\n--------------------");
    }
}
