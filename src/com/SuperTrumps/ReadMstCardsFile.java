package com.SuperTrumps;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * Created by cameronkent on 31/08/2016.
 */


public class ReadMstCardsFile {

    public static void main(String[] args){

        try {
            File inputFile = new File("MstCards_151021.plist");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("cards");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("File name : " + eElement.getAttribute("fileName"));
                    System.out.println("Image Name : " + eElement.getElementsByTagName("imageName").item(0).getTextContent());
                    System.out.println("Card Type: " + eElement.getElementsByTagName("card_type").item(0).getTextContent());
                    System.out.println("Card Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Card Chemistry : " + eElement.getElementsByTagName("chemistry").item(0).getTextContent());
                    System.out.println("Classification : " + eElement.getElementsByTagName("classification").item(0).getTextContent());
                    System.out.println("Crystal System : " + eElement.getElementsByTagName("crystal_system").item(0).getTextContent());
                    System.out.println("Occurrence : " + eElement.getElementsByTagName("occurrence").item(0).getTextContent());
                    System.out.println("Hardness : " + eElement.getElementsByTagName("hardness").item(0).getTextContent());
                    System.out.println("Specific Gravity : " + eElement.getElementsByTagName("specific_gravity").item(0).getTextContent());
                    System.out.println("Cleavage : " + eElement.getElementsByTagName("cleavage").item(0).getTextContent());
                    System.out.println("Crystal Abundance : " + eElement.getElementsByTagName("crystal_abundance").item(0).getTextContent());
                    System.out.println("Economic Value : " + eElement.getElementsByTagName("economic_value").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}