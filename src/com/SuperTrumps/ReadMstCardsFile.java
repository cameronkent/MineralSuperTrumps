package com.SuperTrumps;

import com.dd.plist.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


public class ReadMstCardsFile {

    public ArrayList<Cards> cardDeck = new ArrayList<>();

    ReadMstCardsFile() throws ParserConfigurationException, ParseException, PropertyListFormatException, IOException {
        try {

            File inputFile = new File("MstCards_151021.plist");
            NSDictionary cardDict = (NSDictionary) PropertyListParser.parse(inputFile);
            NSArray cardArray = (NSArray) cardDict.objectForKey("cards");

            //do something with cardArray

        }
        catch (Exception e) {
        e.printStackTrace();
        }

    }
}

//                    fileName
//                    imageName
//                    card_type
//                    title
//                    chemistry
//                    classification
//                    crystal_system
//                    occurrence
//                    hardness
//                    specific_gravity
//                    cleavage
//                    crystal_abundance
//                    economic_value
