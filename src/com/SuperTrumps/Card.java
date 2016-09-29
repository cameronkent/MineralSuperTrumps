package com.SuperTrumps;

import com.dd.plist.NSArray;
import com.dd.plist.NSString;

//                    fileName
//                    imageName
//                    card_type
public class Card {

    String title;
    String chemistry;
    String classification;
    String crystalSystem;
    String hardness;
    String specificGravity;
    String cleavage;
    String crustalAbundance;
    String economicValue;
    NSArray occurrence;
    public boolean isTrump;


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
        this.isTrump = false;
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
                categoryInPlay = this.hardness;
                return categoryInPlay;
            case 2:
                categoryInPlay = this.specificGravity;
                return categoryInPlay;
            case 3:
                categoryInPlay = this.cleavage;
                return categoryInPlay;
            case 4:
                categoryInPlay = this.crustalAbundance;
                return categoryInPlay;
            case 5:
                categoryInPlay = this.economicValue;
                return categoryInPlay;
        } return categoryInPlay;
    }

    public static String getCategoryAsString(int categorySelect) {
        String categoryInPlay = "";
        switch (categorySelect) {
            case 1:
                categoryInPlay = "Hardness";
                return categoryInPlay;
            case 2:
                categoryInPlay = "Specific gravity";
                return categoryInPlay;
            case 3:
                categoryInPlay = "Cleavage";
                return categoryInPlay;
            case 4:
                categoryInPlay = "Crustal abundance";
                return categoryInPlay;
            case 5:
                categoryInPlay = "Economic value";
                return categoryInPlay;
        } return categoryInPlay;
    }

    public String getTitle() {
        return this.title;
    }
}
