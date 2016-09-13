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
        return ("--------------------------------------------------" +
                "\n ELEMENT:            " + this.title +
//                "\n CHEMISTRY:          " + this.chemistry +
//                "\n CLASSIFICATION:     " + this.classification +
//                "\n CRYSTAL SYSTEM:     " + this.crystalSystem +
//                "\n OCCURRENCE:         " + this.occurrence +
                "\n--------------------------------------------------" +
                "\n CATEGORIES\n" +
                "\n Hardness:           " + this.hardness +
                "\n Specific gravity:   " + this.specificGravity +
                "\n Cleavage:           " + this.cleavage +
                "\n Crustal Abundance:  " + this.crustalAbundance +
                "\n Economic value:     " + this.economicValue +
                "\n--------------------------------------------------\n");
    }
}
