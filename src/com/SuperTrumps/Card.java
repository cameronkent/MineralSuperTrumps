package com.SuperTrumps;

import com.dd.plist.NSArray;
import com.dd.plist.NSString;

//                    fileName
//                    imageName
//                    card_type
public class Card {

    String title, chemistry, classification, crystalSystem, hardness, specificGravity, cleavage, crustalAbundance, economicValue;
    NSArray occurrence;

    public Card() {}

    //Construct card
    public Card(NSString title, NSString chemistry, NSString classification, NSString crystalSystem, NSArray occurrence, NSString hardness, NSString specificGravity, NSString cleavage, NSString crustalAbundance, NSString economicValue) {
        this.title = title.toString();
        this.chemistry = chemistry.toString();
        this.classification = classification.toString();
        this.crystalSystem = crystalSystem.toString();
        this.occurrence = occurrence;
        this.hardness = hardness.toString();
        this.specificGravity = specificGravity.toString();
        this.cleavage = cleavage.toString();
        this.crustalAbundance = crustalAbundance.toString();
        this.economicValue = economicValue.toString();

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

    public String getCategoryInPlay(int categorySelect) {
        String categoryInPlay = "";
        switch (categorySelect) {
            case 1:
                categoryInPlay = hardness;
                return categoryInPlay;
            case 2:
                categoryInPlay = specificGravity;
                return categoryInPlay;
            case 3:
                categoryInPlay = cleavage;
                return categoryInPlay;
            case 4:
                categoryInPlay = crustalAbundance;
                return categoryInPlay;
            case 5:
                categoryInPlay = economicValue;
                return categoryInPlay;
        } return categoryInPlay;
    }

    // TODO: make this work... maybe
//    public NSString getCategoryInPlay(int categorySelect ) {
//        NSString categoryInPlay;
//            switch (categorySelect) {
//                case 1: return categoryInPlay = hardness;
//                case 2: return categoryInPlay = specificGravity;
//                case 3: return categoryInPlay = cleavage;
//                case 4: return categoryInPlay = crustalAbundance;
//                case 5: return categoryInPlay = economicValue;
//                default: return categoryInPlay = null;
//            }
//    }
}
