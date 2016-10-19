package com.SuperTrumps.GUI;

import com.SuperTrumps.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainUI {

    static public boolean gameOver;
    static public JFrame gameFrame;
    static public BufferedImage backOfCard;
//    static public int numPlayers;
//    static public String playerName;

    static public String gameMessage;
    static public Game gameST;

    public static void main(String[] args) throws Exception {

        gameFrame = new JFrame("Mineral SuperTrumps");
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setWelcomeContent();

    }

    public static void setWelcomeContent() {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(2,1));

        JPanel messagePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the Mineral SuperTrumps game");
        messagePanel.add(welcomeLabel);
        welcomePanel.add(messagePanel);

        JPanel buttonPanel = new JPanel();
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGameButtonPressed(); }

            private void newGameButtonPressed() {
                welcomePanel.setVisible(false);
                setConfigContent();
            }
        } );
        JButton viewRulesButton = new JButton("View Rules");
        buttonPanel.add(newGameButton);
        buttonPanel.add(viewRulesButton);
        welcomePanel.add(buttonPanel);

        gameFrame.setContentPane(welcomePanel);
        gameFrame.pack();

    }

    public static void setConfigContent() {
        JPanel configPanel = new JPanel();
        configPanel.setLayout(new GridLayout(4, 1));

        JPanel messagePanel = new JPanel();
        JLabel messageLabel = new JLabel("Choose your game settings");
        messagePanel.add(messageLabel);
        configPanel.add(messagePanel);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Enter your Name");
        JTextField nameInput = new JTextField(12);
        namePanel.add(nameLabel);
        namePanel.add(nameInput);
        configPanel.add(namePanel);

        JPanel numPlayersPanel = new JPanel();
        JLabel numPlayersLabel = new JLabel("Number of opponents");
        Integer[] num = {2,3,4};
        JComboBox numPlayersInput = new JComboBox(num);
        numPlayersPanel.add(numPlayersLabel);
        numPlayersPanel.add(numPlayersInput);
        configPanel.add(numPlayersPanel);

        JPanel buttonPanel = new JPanel();
        JButton startGameButton = new JButton("Start Game");
        startGameButton.setEnabled(false);
        nameInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {nameEntered();}

            @Override
            public void removeUpdate(DocumentEvent e) {nameEntered();}

            @Override
            public void changedUpdate(DocumentEvent e) {nameEntered();}

            private void nameEntered() {
                if (nameInput.getText().equals("")) {startGameButton.setEnabled(false);}
                else {startGameButton.setEnabled(true);}
            }
        });

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gameST = new Game((int) numPlayersInput.getSelectedItem());
                gameST.setUserPlayer(nameInput.getText());
                gameST.setComPlayers();
                try {gameST.buildCardDeck();
                } catch (Exception e1) {
                    e1.printStackTrace();}
                gameST.randomiseDealer();
                gameST.dealPlayerHands();
                gameMessage = ("There are " + ((gameST.numPlayers)  + 1) + " players in this game.\n" +
                        gameST.dealerName + " is dealing this round");

                setGameTableContent();
            }
        });

        JButton menuButton = new JButton("Main Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWelcomeContent();
            }
        });

        buttonPanel.add(startGameButton);
        buttonPanel.add(menuButton);
        configPanel.add(buttonPanel);

        gameFrame.setContentPane(configPanel);
        gameFrame.pack();

    }

    public static void setGameTableContent() {

        JPanel TablePanel = new JPanel();
        TablePanel.setLayout(new BorderLayout());
        JPanel messagePanel = new JPanel();

        messagePanel.setPreferredSize(new Dimension(800, 50));
        JLabel messageLabel = new JLabel(gameMessage);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        messagePanel.add(messageLabel);
        TablePanel.add(messagePanel, BorderLayout.NORTH);

        JPanel gameTablePanel = new JPanel();
        gameTablePanel.setLayout(new GridLayout(3, 1));

        JPanel comPlayerPanel = new JPanel();
        comPlayerPanel.setLayout(new GridLayout(1,gameST.numPlayers));

        JLabel comInfo[] = new JLabel[gameST.numPlayers];
        for (int i = 0; i < gameST.numPlayers; i++) {
            comInfo[i] = new JLabel(gameST.comPlayer[i].playerName + "\n" + "Cards " + gameST.comPlayer[i].Hand.size(), SwingConstants.CENTER);
            comPlayerPanel.add(comInfo[i]);
        }
        gameTablePanel.add(comPlayerPanel);

        JPanel cardDeckPanel = new JPanel();

        FaceDownCardPanel gameDeck = new FaceDownCardPanel();
        gameDeck.setPreferredSize(new Dimension(200, 300));
        JLabel gameDeckLabel = new JLabel("SuperTrump Deck: " + gameST.cardDeck.size(), SwingConstants.CENTER);

        FaceDownCardPanel cardInPlay = new FaceDownCardPanel();
        cardInPlay.setPreferredSize(new Dimension(200, 300));
        JLabel cardInPlayLabel = new JLabel("Card in play", SwingConstants.CENTER);

        cardDeckPanel.add(gameDeckLabel);
        cardDeckPanel.add(gameDeck);
        cardDeckPanel.add(cardInPlay);
        cardDeckPanel.add(cardInPlayLabel);

        gameTablePanel.add(cardDeckPanel);

        JPanel playerTablePanel = new JPanel();
        JPanel leftButtonPanel = new JPanel();
        leftButtonPanel.setLayout(new GridLayout(2,1));
        JButton viewRulesButton = new JButton("View Rules");
        JButton quitGameButton = new JButton("Quit Game");
        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWelcomeContent();
            }
        });
        leftButtonPanel.add(viewRulesButton);
        leftButtonPanel.add(quitGameButton);
        playerTablePanel.add(leftButtonPanel);
        JPanel playerHandPanel = new JPanel();
//        Player Hand as JPanels
//        for (int i = 0; i < gameST.userPlayer.Hand.size(); i++) {
//            MainUI.FaceUpCardPanel faceUpCard = new MainUI.FaceUpCardPanel(gameST.userPlayer.Hand.get(i).getFileName());
//            faceUpCard.setPreferredSize(new Dimension(200,300));
//            playerHandPanel.add(faceUpCard);
//        }
//        Player Hand as Buttons
        JButton cards[] = new JButton[gameST.userPlayer.Hand.size()];
        for (int i = 0; i < gameST.userPlayer.Hand.size(); i++) {
            ImageIcon cardImage = new ImageIcon("images/" + gameST.userPlayer.Hand.get(i).getFileName());
            Image img = cardImage.getImage() ;
            Image newImg = img.getScaledInstance( 200, 300,  java.awt.Image.SCALE_SMOOTH ) ;
            cardImage = new ImageIcon( newImg );

            cards[i] = new JButton(cardImage);
            cards[i].setPreferredSize(new Dimension(200,300));
            playerHandPanel.add(cards[i]);
        }
        playerTablePanel.add(playerHandPanel);

        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setLayout(new GridLayout(2,1));
        JButton playCardButton = new JButton("Play Card");
        playCardButton.setEnabled(false);
        JButton passTurnButton = new JButton("Pass Turn");
        passTurnButton.setEnabled(false);

        rightButtonPanel.add(playCardButton);
        rightButtonPanel.add(passTurnButton);
        playerTablePanel.add(rightButtonPanel);
        gameTablePanel.add(playerTablePanel);
        TablePanel.add(gameTablePanel);

        gameFrame.setContentPane(TablePanel);
        gameFrame.pack();
    }

    public static class FaceDownCardPanel extends JPanel {

        public FaceDownCardPanel() {
            try {
                backOfCard = ImageIO.read(new File("images/Slide65.jpg"));
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backOfCard, 0, 0, 200, 300, null);
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
