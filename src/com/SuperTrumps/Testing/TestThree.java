package com.SuperTrumps.Testing;

import com.SuperTrumps.Deck;
import com.SuperTrumps.Game;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestThree {

    static public JFrame gameFrame;
    static public BufferedImage backOfCard;
//    static public ImageIcon image;
    static public Deck cardDeck;

    public static void main(String[] args) throws Exception {

        gameFrame = new JFrame("Mineral SuperTrumps");
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardDeck = new Deck();

        JPanel TablePanel = new JPanel();

        JButton cards[] = new JButton[cardDeck.size()];

        for (int i = 0; i < cardDeck.size(); i++) {

            ImageIcon cardImage = new ImageIcon("images/" + cardDeck.deckArray.get(i).getFileName());
            Image img = cardImage.getImage() ;
            Image newImg = img.getScaledInstance( 100, 150,  java.awt.Image.SCALE_SMOOTH ) ;
            cardImage = new ImageIcon( newImg );

            cards[i] = new JButton(cardImage);
            cards[i].setPreferredSize(new Dimension(100,150));
            TablePanel.add(cards[i]);
        }

        gameFrame.add(TablePanel);
        gameFrame.pack();

    }

    public static void setContent() {

        JPanel TablePanel = new JPanel();

        FaceUpCardPanel cards[] = new FaceUpCardPanel[cardDeck.size()];
        for (int i = 0; i < cardDeck.size(); i++) {
            cards[i] = new FaceUpCardPanel(cardDeck.deckArray.get(i).getFileName());
            cards[i].setPreferredSize(new Dimension(200,300));
            TablePanel.add(cards[i]);
        }

        gameFrame.setContentPane(TablePanel);
        gameFrame.pack();
    }

    public static class createImageIcon extends JPanel{

        public createImageIcon(String path) {
            try {
                backOfCard = ImageIO.read(new File("images/" + path));
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backOfCard, 0, 0, 100, 150, null);
        }
    }

    public static class FaceUpCardPanel extends JPanel {
        BufferedImage cardFace;

        public FaceUpCardPanel(String imageFileName) {
            try {
                cardFace = ImageIO.read(new File("images/" + imageFileName));
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(cardFace, 0, 0, 200, 300, null);
        }
    }
}
